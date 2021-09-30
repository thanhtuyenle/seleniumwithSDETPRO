package apilearning;

import driver.DriverChrome;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertLearning {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverChrome.getChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            By jsAlert = By.cssSelector("#content > div > ul button[onclick=\"jsAlert()\"]");
            By jsConfirm = By.cssSelector("#content > div > ul button[onclick=\"jsConfirm()\"]");
            By jsPrompt = By.cssSelector("#content > div > ul button[onclick=\"jsPrompt()\"]");

            WebElement eJSAlert = driver.findElement(jsAlert);
            WebElement eJSConfirm = driver.findElement(jsConfirm);
            WebElement eJSPrompt = driver.findElement(jsPrompt);

            WebDriverWait wait = new WebDriverWait(driver, 30);

            eJSAlert.click();
            Thread.sleep(2000);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            Thread.sleep(2000);

            eJSConfirm.click();
            Thread.sleep(2000);
            Alert alertConfirm = wait.until(ExpectedConditions.alertIsPresent());
            alertConfirm.dismiss();
            Thread.sleep(2000);

            eJSPrompt.click();
            Thread.sleep(2000);
            Alert alertPrompt = wait.until(ExpectedConditions.alertIsPresent());
            alertPrompt.sendKeys("Hello Tuyen, happy birthday to you!");
            Thread.sleep(5000);
            alertPrompt.accept();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }

    }
}
