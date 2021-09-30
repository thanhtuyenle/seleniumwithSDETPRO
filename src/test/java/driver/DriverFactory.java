package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        if(webDriver == null) {
            webDriver = DriverChrome.getChromeDriver();
        }
        return webDriver;
    }

    public void quitDriver() {
        if(webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

}
