package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.Assert;

public class LoginPage {
    private final By usernameField = By.xpath("//input[@placeholder='Username']");
    private final By passwordField = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");
    private final ChromiumDriver driver;
    public LoginPage(ChromiumDriver driver) {
        this.driver = driver;
    }
    public void orangeLogin(String username, String password) {
        WebElement usernameInput = driver.findElement(usernameField);
//        Assert.assertTrue(usernameInput.isDisplayed(), "Element is not displayed on the page.");
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordField);
//        Assert.assertTrue(passwordInput.isDisplayed(), "Element is not displayed on the page.");
        passwordInput.sendKeys(password);
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }
}
