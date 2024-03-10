package org.webapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase {

    @Test (priority = 0)
    public void checkIfMainPageTest() {
        mainPage.waitUntilPageIsOpened();
        Assert.assertEquals(mainPage.getHeader(),"OpenWeather");

    }
    @Test (priority = 1)
    public void checkGuidePage(){
        mainPage.waitUntilPageIsOpened();
        guidePage.openPage();
        guidePage.waitUntilPageIsOpened();
        Assert.assertEquals(guidePage.getHeader(),"Guide");
        mainPage.openPage();

    }

    @Test (priority = 1)
    public void checkApiPage(){
        mainPage.waitUntilPageIsOpened();
        apiPage.openPage();
        apiPage.waitUntilPageIsOpened();
        Assert.assertEquals(apiPage.getHeader(),"Weather API");
        mainPage.openPage();
    }

    @Test (priority = 1)
    public void checkDashboardPage(){
        mainPage.waitUntilPageIsOpened();
        dashboardPage.openPage();
        dashboardPage.waitUntilPageIsOpened();
        Assert.assertEquals(apiPage.getHeader(),"Weather dashboard");
        mainPage.openPage();
    }
    @Test (priority = 2)
    public void searchCityTest(){
        String name = "Tel Aviv";
        mainPage.waitUntilPageIsOpened();
        mainPage.searchCity(name);
        Assert.assertTrue(mainPage.getHeaderWithNameCity().contains(name));
    }

}
