package com.otlob.tests;


import com.otlob.actions.RestaurantsAction;
import com.otlob.engine.BaseTest;
import com.otlob.utilities.extent.ExtentTestManager;
import com.otlob.utilities.listeners.TestListener;
import com.otlob.utilities.excel.ExcelUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestListener.class})
public class AllRestaurantsTest extends BaseTest {

    @Test(priority = 1, description = "Validate that the user can search for restaurants")
    public void ValidateThatUserCanSearchForRestaurants() {
        // set excel file OtlobTest.xlsx
        ExcelUtils.setExcelFile(System.getProperty("user.dir") + "\\testdata\\OtlobTest.xlsx");
        // get testID And testName from excel sheet
        String testID = ExcelUtils.getCellData(1, 0, "TCs");
        String testName = ExcelUtils.getCellData(1, 1, "TCs");
        // log TC to report
        ExtentTestManager.startTest(testID + ": " + testName);
        // navigate to All Restaurants page
        RestaurantsAction.navigateToAllRestaurants();
        // get row count of Restaurants sheet
        int iTotalRestaurants = ExcelUtils.getRowCount("Restaurants");
        // get multiple restaurant names from excel sheet
        for (int iRestaurant = 1; iRestaurant < iTotalRestaurants; iRestaurant++) {
            // get restaurantName to replace searchResult variable xpath
            String restaurantName = ExcelUtils.getCellData(iRestaurant, 0, "Restaurants");
            // get searchKeyword to use in search
            String searchKeyword = ExcelUtils.getCellData(iRestaurant, 1, "Restaurants");
            // validate search result versus search keyword
            RestaurantsAction.searchAndValidateResults(restaurantName, searchKeyword);
        }
    }

    @Test(priority = 2, description = "Validate that the user can check restaurants rating", successPercentage = 70)
    public void validateThatUserCanCheckRestaurantsRating() {
        // set excel file OtlobTest.xlsx
        ExcelUtils.setExcelFile(System.getProperty("user.dir") + "\\testdata\\OtlobTest.xlsx");
        // get testID And testName from excel sheet
        String testID = ExcelUtils.getCellData(2, 0, "TCs");
        String testName = ExcelUtils.getCellData(2, 1, "TCs");
        // log TC to report
        ExtentTestManager.startTest(testID + ": " + testName);
        // navigate to All Restaurants page
        RestaurantsAction.navigateToAllRestaurants();
        // get row count of Restaurants sheet
        int iTotalRestaurants = ExcelUtils.getRowCount("Restaurants");
        // get multiple restaurant names from excel sheet
        for (int iRestaurant = 1; iRestaurant < iTotalRestaurants; iRestaurant++) {
            // get restaurantName to replace searchResult variable xpath
            String restaurantName = ExcelUtils.getCellData(iRestaurant, 0, "Restaurants");
            // get searchKeyword to use in search
            String searchKeyword = ExcelUtils.getCellData(iRestaurant, 1, "Restaurants");
            // search for restaurant
            RestaurantsAction.searchForRestaurant(searchKeyword);
            // check restaurant's rating
            RestaurantsAction.checkRating(restaurantName);
            // go back to All Restaurants
            RestaurantsAction.goBackToAllRestaurants();
        }
    }
}


