package com.solvd.carina.demo.swaglabs.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends AbstractPage {

    @FindBy(className = "complete-header")
    private ExtendedWebElement completeHeader;

    protected CompletePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(completeHeader);
    }

    public boolean isCompleteHeaderCorrect(){
        return completeHeader.getText().equals("Thank you for your order!");
    }
}
