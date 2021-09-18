package testflows;

import models.pages.TheInternetLoginPage;
import models.pages.TheSecurePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginFlow {
    private final WebDriver driver;

    public LoginFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void loginWithCorrectCredentials(String username, String password) {
        TheInternetLoginPage theInternetLoginPage = new TheInternetLoginPage(driver);
        theInternetLoginPage.inputUsername(username).inputPassword(password).clickLogin();
    }

    public void verifyLoginSuccessfully(String username, String password) {
        loginWithCorrectCredentials(username,password);
        TheSecurePage theSecurePage = new TheSecurePage(driver);
        String actualTitle = theSecurePage.getTitleText();

        String expectedTitle = "Secure Area";
        Assert.assertEquals(actualTitle,expectedTitle, "[ERR]: actual title is not equal to expected title");
    }

    public void loginWithInvalidCredentials(String username, String password) {
        TheInternetLoginPage theInternetLoginPage = new TheInternetLoginPage(driver);
        if(username.isEmpty()) {
            theInternetLoginPage.inputPassword(password).clickLogin();
            verifyErrWithWrongCredentials();
        }
        if(password.isEmpty()) {
            theInternetLoginPage.inputUsername(username).clickLogin();
            verifyErrWithWrongCredentials();
        }
        if(username.isEmpty() && password.isEmpty()) {
            theInternetLoginPage.clickLogin();
            verifyErrWithWrongCredentials();
        }
    }
    public void verifyErrWithWrongCredentials() {
        TheInternetLoginPage theInternetLoginPage = new TheInternetLoginPage(driver);
        String errorMessage = theInternetLoginPage.getErrorMessage();
        String errorBackgroundColor = theInternetLoginPage.getErrorBackGroundColor();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorBackgroundColor, "#c60f13","[ERR] : back ground color is not #c60f13");
        softAssert.assertTrue(errorMessage.contains("is invalid"), "[ERR]: error message does not contain invalid");
        softAssert.assertAll();
    }
}
