package components.global;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class FooterTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testHomepageFooter(driver);
            testCategoryFooter(driver);
            testProductItemFooter(driver);
            testAboutUsFooter(driver);
        } finally {
            driver.quit();
        }
    }

    public static void testHomepageFooter(WebDriver driver) {
        driver.get("http://demowebshop.tricentis.com/");

        //verify common header points
        commonFooterTest(driver);
    }

    public static void testCategoryFooter(WebDriver driver) {
        driver.get("http://demowebshop.tricentis.com/");
        List<WebElement> categoryLinks = driver.findElements(By.cssSelector(".header-menu > ul.top-menu > li > a"));
        WebElement randomCategory = categoryLinks.get(new SecureRandom().nextInt(categoryLinks.size()));
        System.out.println("Category's name: " + randomCategory.getText());
        randomCategory.click();

        //verify common header points
        commonFooterTest(driver);
    }

    public static void testProductItemFooter(WebDriver driver) {
    }

    public static void testAboutUsFooter(WebDriver driver) {
    }

    private static void commonFooterTest(WebDriver driver) {
        commonInformationTest(driver);
        commonCustomerServiceTest(driver);
        commonMyAccountTest(driver);
        commonFollowUsTest(driver);
    }

    private static void commonInformationTest(WebDriver driver) {

        List<WebElement> footerInformationLinks = driver.findElements(By.cssSelector(".column.information > ul > li > a"));
        for(WebElement link: footerInformationLinks) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }

    private static void commonCustomerServiceTest(WebDriver driver) {
        List<WebElement> footerCustomerServiceLinks = driver.findElements(By.cssSelector(".column.customer-service > ul > li > a"));
        for(WebElement link: footerCustomerServiceLinks) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }

    private static void commonMyAccountTest(WebDriver driver) {
        List<WebElement> footerMyAccountLinks = driver.findElements(By.cssSelector(".column.my-account > ul > li > a"));
        for(WebElement link: footerMyAccountLinks) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }

    private static void commonFollowUsTest(WebDriver driver) {
        List<WebElement> footerFollowUsLinks = driver.findElements(By.cssSelector(".column.follow-us > ul > li > a"));
        for(WebElement link: footerFollowUsLinks) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }
}
