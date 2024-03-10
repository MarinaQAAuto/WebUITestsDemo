package org.webapp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.webapp.pages.APIPageHelper;
import org.webapp.pages.DashboardPageHelper;
import org.webapp.pages.GuidePageHelper;
import org.webapp.pages.MainPageHelper;

public class TestBase {
    public static WebDriver driver;
    public static MainPageHelper mainPage;
    public static GuidePageHelper guidePage;
    public static APIPageHelper apiPage;
    public static DashboardPageHelper dashboardPage;


    @BeforeSuite
    public void startUp1Init()  {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://openweathermap.org/");
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        guidePage = PageFactory.initElements(driver, GuidePageHelper.class);
        apiPage = PageFactory.initElements(driver, APIPageHelper.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPageHelper.class);

    }

    @BeforeClass
    public void startUp2Act()  {
        mainPage.waitUntilPageIsOpened();
    }

    @AfterSuite
    public void tearDown(){

        driver.quit();
    }
}
