package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TheInternetLoginPage {
    private final WebDriver driver;

    private final By usernameSelector = By.cssSelector("#username");
    private final By passwordSelector = By.cssSelector("#password");
    private final By loginSelector = By.cssSelector("button[type=\"submit\"]");

    private final By invalidMessage = By.cssSelector("#flash");

    public TheInternetLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public TheInternetLoginPage inputUsername(String username) {
        driver.findElement(usernameSelector).sendKeys(username);
        return this;
    }

    public TheInternetLoginPage inputPassword(String password) {
        driver.findElement(passwordSelector).sendKeys(password);
        return this;
    }

    public void clickLogin() {
        driver.findElement(loginSelector).click();
    }

    public String getErrorMessage() {
        return driver.findElement(invalidMessage).getText();
    }

    public String getErrorBackGroundColor() {
        return driver.findElement(invalidMessage).getAttribute("background-color");
    }

}
