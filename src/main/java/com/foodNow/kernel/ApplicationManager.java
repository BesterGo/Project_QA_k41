package com.foodNow.kernel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    public WebDriver driver;
    BaseHelper baseHelper;


    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseHelper = new BaseHelper(driver);
        String appUrl = "https://oyster-app-hck73.ondigitalocean.app/#/";
        driver.get(appUrl);
        logger.info("Application started at: " + appUrl);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }
}
