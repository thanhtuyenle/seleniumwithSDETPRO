package components.global;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class HeaderTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testHomepageHeader(driver);
            testCategoryHeader(driver);
            testProductItemHeader(driver);
            testAboutUsHeader(driver);
        } finally {
            driver.quit();
        }
    }

    public static void testHomepageHeader(WebDriver driver) {
        driver.get("http://demowebshop.tricentis.com/");

        //verify common header points
        commonHeaderTest(driver);
    }

    public static void testCategoryHeader(WebDriver driver) {
        driver.get("http://demowebshop.tricentis.com/");
        List<WebElement> categoryLinks = driver.findElements(By.cssSelector(".header-menu > ul.top-menu > li > a"));
        WebElement randomCategory = categoryLinks.get(new SecureRandom().nextInt(categoryLinks.size()));
        System.out.println("Category's name: " + randomCategory.getText());
        randomCategory.click();

        //verify common header points
        commonHeaderTest(driver);
    }

    public static void testProductItemHeader(WebDriver driver) {
    }

    public static void testAboutUsHeader(WebDriver driver) {
    }

    private static void commonHeaderTest(WebDriver driver) {
        WebElement headerLogo = driver.findElement(By.cssSelector(".header .header-logo img"));
        System.out.println("Is logo displayed: " + headerLogo.isDisplayed());

        List<WebElement> headerLinks = driver.findElements(By.cssSelector(".header-links ul > li > a"));
        for(WebElement link: headerLinks) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }
}
