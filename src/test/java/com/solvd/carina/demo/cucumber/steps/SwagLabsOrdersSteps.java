package com.solvd.carina.demo.cucumber.steps;

import com.solvd.carina.demo.swaglabs.model.Order;
import com.solvd.carina.demo.swaglabs.model.User;
import com.solvd.carina.demo.swaglabs.pages.*;
import com.solvd.carina.demo.swaglabs.services.implementation.UserService;
import com.solvd.carina.demo.swaglabs.services.interfaces.IUserService;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SwagLabsOrdersSteps extends CucumberRunner{

    private LoginPage loginPage = null;
    private HomePage homePage = null;
    private CartPage cartPage = null;
    private CheckoutOverviewPage checkoutOverviewPage = null;
    private User user;

    @Given("Login page is opened")
    public void loginPageIsOpened() {
        loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "LoginPage was not opened");
    }

    @When("{} log in with user credentials taken from data base")
    public void loginWithUserCredentialsFromDatabase(UserName userName) {
        IUserService iUserService = new UserService();
        user = iUserService.getEntityById(userName.getId());
        homePage = loginPage.login(user);
    }

    @And("Add orders which are stored in data base for mentioned user")
    public void addOrdersFromDatabase() {
        Assert.assertFalse(user.getOrders().isEmpty(), "There are no products in DB for this user");
        for (Order usersOrder : user.getOrders()) {
            homePage.addProductToCart(usersOrder.getProduct());
        }
    }

    @And("Proceed to checkout")
    public void proceedToCheckout(){
        cartPage = homePage.goToCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "CartPage was not opened");
        Assert.assertEquals(user.getOrders().size(), cartPage.getNumberOfProductsInCart(),
                "Not all of the user's orders have been added to the cart");
        CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
        Assert.assertTrue(checkoutPage.isPageOpened(), "CheckoutPage was not opened");
        checkoutOverviewPage = checkoutPage.enterUserInfo(user);
        Assert.assertTrue(checkoutOverviewPage.isPageOpened(), "CheckoutOverviewPage was not opened");
    }

    @Then("Order successfully created")
    public void checkSuccessfulOrderStatus(){
        CompletePage completePage = checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(completePage.isPageOpened(), "CompletePage was not opened");
        Assert.assertTrue(completePage.isCompleteHeaderCorrect(), "Order creation was not successful");
    }

    public enum UserName {
        TIM(1), JEFF(2), ELON(3);

        final int id;

        UserName(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
