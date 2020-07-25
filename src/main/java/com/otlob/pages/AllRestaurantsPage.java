package com.otlob.pages;

import com.otlob.engine.BasePage;
import com.otlob.utilities.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

public class AllRestaurantsPage extends BasePage {

    public AllRestaurantsPage(WebDriver driver) {
        super(driver);
    }

    public AllRestaurantsPage search(String searchKeyword) {
        try {
            writeText("searchField", searchKeyword);
            ExtentTestManager.getTest().log(LogStatus.PASS, "Searched for '" + searchKeyword + "'");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Couldn't Search for '" + searchKeyword + "'");
        }
        return this;
    }

    public void validateSearchResult(String restaurantName, String searchKeyword) {
        try {
            String searchResult = readByValue("availableResult", restaurantName);
            softAssert.assertTrue(searchResult.toLowerCase().contains(searchKeyword.toLowerCase()));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Search result '" + searchResult + "' matches search keyword");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Search result & search keyword don't match");
        }
    }

    public RestaurantDetailsPage selectRestaurant(String restaurantName) {
        try {
            clickByValue("availableResult", restaurantName);
            ExtentTestManager.getTest().log(LogStatus.PASS, "Selected '" + restaurantName + "' restaurant");
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Couldn't select '" + restaurantName + "' restaurant");
        }
        return new RestaurantDetailsPage(driver);
    }

}