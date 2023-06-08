package com.solvd.carina.demo.swaglabs.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends AbstractPage {

    @FindBy(id = "finish")
    private ExtendedWebElement finishButton;

    protected CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(finishButton);
    }

    public CompletePage clickFinishButton() {
        finishButton.click();
        return new CompletePage(getDriver());
    }
}
