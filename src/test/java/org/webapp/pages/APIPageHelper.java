package org.webapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class APIPageHelper extends PageBase {
    @FindBy (xpath = "//li[@id='desktop-menu']//a[contains(text(),'API')]/..")
    WebElement apiMenu;
    @FindBy (xpath = "//h1")
    WebElement header;

    public APIPageHelper(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        this.waitUntilElementIsVisible(apiMenu,20);
        this.waitUntilElementIsClickable(apiMenu, 15);
        apiMenu.click();
    }

    public void waitUntilPageIsOpened(){
        this.waitUntilElementIsVisible(header,10);
    }

    public String getHeader(){
        return header.getText();
    }
}
