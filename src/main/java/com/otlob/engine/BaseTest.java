package com.otlob.engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        // setup chrome driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // maximize window
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // load object repository
        DriverScript.objectRepoLoad();
    }

    @BeforeMethod
    public void openBaseURL() {
        // open base URL
        driver.get("https://www.otlob.com/egypt");
    }


    @AfterClass
    public void teardown() {
        // quitting web driver
        driver.quit();
    }

}
