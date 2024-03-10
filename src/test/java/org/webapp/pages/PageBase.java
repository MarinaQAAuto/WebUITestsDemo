package org.webapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void sleepSec(int sec){
        int ms = sec*1000;
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillField(WebElement field, String text){
        field.clear();
        field.click();
        field.sendKeys(text);
        sleepSec(1);
    }

    public void waitUntilElementIsInVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementContainsAttributeWithText(WebElement element, String attribute, String text, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.attributeContains(element, attribute, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsAreVisible(List<WebElement> elements, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilFrameToBeAvailableAndSwitchToIt(By locator, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementExists(By locator, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsExist(By locator, int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
