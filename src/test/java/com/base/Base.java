package com.base;

import com.google.gson.JsonObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class Base {
    private static final Logger logger = LogManager.getLogger(Base.class);
    public ChromiumDriver driver;
    JsonObject jsonObject;
    public Properties properties;
    private final JsonConverter jsonConverter=new JsonConverter();

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
//        System.setProperty("log4j.configurationFile", "log4j2.xml");
        logger.info("beforeSuite started");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        properties = new Properties();
        try {
            properties.load(new FileReader(System.getProperty("user.dir")+"/src/test/resources/config/base.properties"));
            jsonObject=jsonConverter.getJson(properties.getProperty("orangeHRMDataPath"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.get(properties.getProperty("baseUrl"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
