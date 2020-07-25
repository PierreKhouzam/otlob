package com.otlob.actions;

import com.otlob.engine.BaseTest;
import com.otlob.pages.RestaurantDetailsPage;
import com.otlob.pages.HomePage;
import com.otlob.pages.AllRestaurantsPage;
import com.otlob.utilities.screenshots.ScreenshotRobot;


public class RestaurantsAction extends BaseTest {

    public static void navigateToAllRestaurants() {
        HomePage homePage = new HomePage(driver);
        homePage.goToAllRestaurants();
        ScreenshotRobot.takeScreenShot(driver);
    }

    public static void searchForRestaurant(String searchKeyword) {
        AllRestaurantsPage allRestaurantsPage = new AllRestaurantsPage(driver);
        allRestaurantsPage.search(searchKeyword);
        ScreenshotRobot.takeScreenShot(driver);
    }

    public static void searchAndValidateResults(String restaurantName , String searchKeyword ) {
        AllRestaurantsPage allRestaurantsPage = new AllRestaurantsPage(driver);
        allRestaurantsPage.search(searchKeyword).validateSearchResult(restaurantName, searchKeyword);
        ScreenshotRobot.takeScreenShot(driver);
    }

    public static void checkRating(String restaurantName) {
        AllRestaurantsPage allRestaurantsPage = new AllRestaurantsPage(driver);
        allRestaurantsPage.selectRestaurant(restaurantName).validateRating();
        ScreenshotRobot.takeScreenShot(driver);
    }


    public static void goBackToAllRestaurants() {
        RestaurantDetailsPage restaurantDetailsPage = new RestaurantDetailsPage(driver);
        restaurantDetailsPage.backToAllRestaurants();
        ScreenshotRobot.takeScreenShot(driver);
    }
}