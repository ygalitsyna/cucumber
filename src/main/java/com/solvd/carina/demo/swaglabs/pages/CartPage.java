package com.solvd.carina.demo.swaglabs.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(className = "shopping_cart_badge")
    private ExtendedWebElement numberOfProductsInCart;

    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutButton;

    protected CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(checkoutButton);
    }

    public int getNumberOfProductsInCart(){
        return Integer.parseInt(numberOfProductsInCart.getText().trim());
    }

    public CheckoutPage goToCheckoutPage() {
        checkoutButton.click();
        return new CheckoutPage(getDriver());
    }
}
