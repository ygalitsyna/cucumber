package com.solvd.carina.demo.swaglabs.pages;

import com.solvd.carina.demo.swaglabs.model.User;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(loginButton);
    }

    public HomePage login(User user){
        usernameInput.type(user.getLogin());
        passwordInput.type(user.getPassword());
        loginButton.click();
        return new HomePage(getDriver());
    }

    public boolean isErrorMessageCorrect(){
        return errorMessage.getText().trim().equals("Epic sadface: Sorry, this user has been locked out.");
    }
}
