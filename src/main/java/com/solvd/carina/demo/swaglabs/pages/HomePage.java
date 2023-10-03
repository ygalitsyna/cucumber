package com.solvd.carina.demo.swaglabs.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='inventory_item_name' and contains(text(),'%s')]")
    private ExtendedWebElement productTitle;

    //@FindBy(xpath = "//div[@class='inventory_item_name' and contains(text(),'%s')]/../../following-sibling::div/button")
    @FindBy(xpath = "//div[@class='inventory_item_name' and contains(text(),'%s')]/parent::a/parent::div/following-sibling::div/button")
    private ExtendedWebElement addToCartButton;

    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement cartButton;

    protected HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(cartButton);
    }

    public HomePage addProductToCart(String productTitleFromDB) {
        productTitle.format(productTitleFromDB.trim());
        addToCartButton.format(productTitleFromDB.trim()).click();
        return this;
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(getDriver());
    }
}
