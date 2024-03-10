package org.webapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageHelper extends PageBase {
    @FindBy (xpath = "//a[./img[@alt='logo']]")
    WebElement logoOpenWeather;
    @FindBy (xpath = "//h1/span")
    WebElement header;
    @FindBy (xpath = "//input[@placeholder='Search city']")
    WebElement searchInput;
    @FindBy (xpath = "//button[@type='submit']")
    WebElement searchButton;
    @FindBy (xpath = "//*[@id='weather-widget']//h2")
    WebElement nameCityHeader;


    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        this.waitUntilElementIsClickable(logoOpenWeather, 15);
        logoOpenWeather.click();
    }

    public void waitUntilPageIsOpened(){
        this.waitUntilElementIsVisible(header,30);
        this.sleepSec(5);
    }

    public String getHeader(){
        return header.getText();
    }

    public void searchCity(String name) {
        this.waitUntilElementIsClickable(searchInput,15);
        this.fillField(searchInput,name);
        searchButton.click();
        this.sleepSec(5);
        driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]/..")).click();
        this.sleepSec(3);
    }

    public String getHeaderWithNameCity() {
        this.waitUntilElementIsVisible(nameCityHeader,10);
        String nameCityHeaderText = nameCityHeader.getText();
        System.out.println("Text: " + nameCityHeaderText);
        return nameCityHeaderText;
    }
}
