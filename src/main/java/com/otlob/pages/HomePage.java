package com.otlob.pages;

import com.otlob.engine.BasePage;
import com.otlob.utilities.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AllRestaurantsPage goToAllRestaurants() {
        try {
            click("allRestaurantsLink");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Navigated to All Restaurants page");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Couldn't reach All Restaurants page");
        }
        return new AllRestaurantsPage(driver);
    }
}
