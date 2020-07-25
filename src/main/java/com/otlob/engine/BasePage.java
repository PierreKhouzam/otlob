package com.otlob.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static com.otlob.engine.DriverScript.objectRepo;


public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SoftAssert softAssert = new SoftAssert();

    // Constructor
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    // wait method
    public static void waitVisibility(String object) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRepo.getProperty(object))));
    }

    // click method
    public static void click(String object) {
        waitVisibility(object);
        driver.findElement(By.xpath(objectRepo.getProperty(object))).click();
    }

    // write text method
    public void writeText(String object, String data) {
        waitVisibility(object);
        driver.findElement(By.xpath(objectRepo.getProperty(object))).clear();
        driver.findElement(By.xpath(objectRepo.getProperty(object))).sendKeys(data);
    }

    // read text method
    public String readText(String object) {
        waitVisibility(object);
        return driver.findElement(By.xpath(objectRepo.getProperty(object))).getText();
    }

    // read variable object value
    public String readByValue(String object, String variable) {
        String objectValue = objectRepo.getProperty(object);
        String newObjectValue = objectValue.replaceFirst("@var", variable);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newObjectValue)));
        return driver.findElement(By.xpath((newObjectValue))).getText();
    }

    // Click variable object value
    public void clickByValue(String object, String variable) {
        String objectValue = objectRepo.getProperty(object);
        String newObjectValue = objectValue.replaceFirst("@var", variable);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newObjectValue)));
        driver.findElement(By.xpath((newObjectValue))).click();
    }
}
