package com.solvd.carina.demo.swaglabs.pages;

import com.solvd.carina.demo.swaglabs.model.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameInput;

    @FindBy(id = "postal-code")
    private ExtendedWebElement zipCodeInput;

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    protected CheckoutPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(continueButton);
    }

    public CheckoutOverviewPage enterUserInfo(User user) {
        firstNameInput.type(user.getFirstName());
        lastNameInput.type(user.getLastName());
        zipCodeInput.type(String.valueOf(user.getZipcode()));
        continueButton.click();
        return new CheckoutOverviewPage(getDriver());
    }
}
