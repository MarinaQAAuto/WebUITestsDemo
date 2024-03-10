package org.webapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageHelper extends PageBase {
    @FindBy (xpath = "//li[@id='desktop-menu']//a[contains(text(),'Dashboard')]/..")
    WebElement dashboardMenu;
    @FindBy (xpath = "//h1")
    WebElement header;

    public DashboardPageHelper(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        this.waitUntilElementIsVisible(dashboardMenu,20);
        this.waitUntilElementIsClickable(dashboardMenu, 15);
        dashboardMenu.click();
    }

    public void waitUntilPageIsOpened(){
        this.waitUntilElementIsVisible(header,10);
    }

    public String getHeader(){
        return header.getText();
    }
}
