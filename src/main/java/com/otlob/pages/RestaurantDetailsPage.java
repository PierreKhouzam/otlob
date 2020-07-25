package com.otlob.pages;

import com.otlob.engine.BasePage;
import com.otlob.utilities.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;


public class RestaurantDetailsPage extends BasePage {

    public RestaurantDetailsPage(WebDriver driver) {
        super(driver);
    }


    public void validateRating() {
        try {
            String rating = readText("rating");
            softAssert.assertTrue(rating.matches(".*\\d.*"));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Checked restaurant's rating equals '" + rating + "'");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Couldn't check restaurant's rating");
        }
    }

    public void backToAllRestaurants() {
        try {
            if (!driver.getCurrentUrl().equals("https://www.otlob.com/egypt/restaurants")) {
                driver.navigate().back();
                waitVisibility("allRestaurantsLabel");
                ExtentTestManager.getTest().log(LogStatus.PASS, "Went back to All Restaurants page");
            } else {
                waitVisibility("allRestaurantsLabel");
                ExtentTestManager.getTest().log(LogStatus.INFO, "Already on All Restaurants page");
            }
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Couldn't reach All Restaurants page");
        }
        new AllRestaurantsPage(driver);
    }
}
