package org.webapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuidePageHelper extends PageBase {
    @FindBy (xpath = "//li[@id='desktop-menu']//a[contains(text(),'Guide')]/..")
    WebElement guideMenu;
    @FindBy (xpath = "//h1")
    WebElement header;

    public GuidePageHelper(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        this.waitUntilElementIsVisible(guideMenu,20);
        this.waitUntilElementIsClickable(guideMenu, 15);
        guideMenu.click();
    }

    public void waitUntilPageIsOpened(){
        this.waitUntilElementIsVisible(header,10);
    }

    public String getHeader(){
        return header.getText();
    }
}
