package apilearning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormHandling {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/login");

            driver.findElement(By.id("username")).sendKeys("Tuyen");

            WebElement usernameCss = driver.findElement(By.cssSelector("#username"));
            usernameCss.clear();
            usernameCss.sendKeys("tomsmith");

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("SuperSecretPassword!");

            WebElement loginBtn = driver.findElement(By.cssSelector("#login > button"));
            loginBtn.click();

            Thread.sleep(3000);

        }catch (NoSuchElementException | InterruptedException e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
