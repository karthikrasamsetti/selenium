package com.base;

import com.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTest extends Base{
    private static final Logger logger = LogManager.getLogger(WebTest.class);
    private LoginPage loginPage;

    @BeforeTest
    public void beforeConditions() {
        loginPage=new LoginPage(driver);
    }
    @Test
    public void login(){
        logger.info("login started");
        String username= jsonObject.get("userName").getAsString();
        String password = jsonObject.get("password").getAsString();
        loginPage.orangeLogin(username,password);
        logger.info("login ended");

    }
}
