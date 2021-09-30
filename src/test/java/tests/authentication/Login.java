package tests.authentication;

import driver.DriverChrome;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testflows.LoginFlow;

public class Login {
    @Test(groups = {"regression", "smoke"})
    public void loginWithValidCredentials() {
        WebDriver driver = DriverChrome.getChromeDriver();
        final String username = "tomsmith";
        final String password = "SuperSecretPassword!";
        try {
            driver.get("https://the-internet.herokuapp.com/login");
            LoginFlow loginFlow = new LoginFlow(driver);
            loginFlow.verifyLoginSuccessfully(username,password);

        }finally {
            driver.quit();
        }
    }

    @Test(groups = {"regression"}, dataProvider = "wrongLoginData")
    public void loginWithInvalidCredentials(String username, String password) {
        WebDriver driver = DriverChrome.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/login");
            LoginFlow loginFlow = new LoginFlow(driver);
            loginFlow.loginWithInvalidCredentials(username, password);
        }finally {
            driver.quit();
        }
    }

    @DataProvider
    public Object[][] wrongLoginData() {
        Object[][] loginData = new Object[2][2];
        loginData[0][0] = "tomsmith_";
        loginData[0][1] = "SuperSecretPassword!";
        loginData[1][0] = "tomsmith";
        loginData[1][1] = "SuperSecretPassword!_";
        return loginData;
    }

}
