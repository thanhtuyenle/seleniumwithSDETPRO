package models.pages;

import driver.DriverFactory;
import models.components.global.FooterComponent;
import models.components.global.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private HeaderComponent headerComponent;
    private FooterComponent footerComponent;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderComponent getHeaderComponent() {
        return new HeaderComponent(driver);
    }

    public FooterComponent getFooterComponent() {
        return new FooterComponent(driver);
    }

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            HomePage homePage = new HomePage(driver);
            driver.get("http://demowebshop.tricentis.com/");

            System.out.println("Logo Header's source: "
                    + homePage.getHeaderComponent().isHeaderLogoDisplayed().getAttribute("src"));

            homePage.getHeaderComponent().inputSearchItemThenClickSearch("laptop");

            Thread.sleep(3000);

            List<WebElement> informationLinks = homePage.getFooterComponent().getMenuInformationComponent().getInformationLinks();
            System.out.println("Information Links:-------");
            for (WebElement link: informationLinks
            ) {
                System.out.println(link.getText());
            }

            List<WebElement> customerServiceLinks = homePage.getFooterComponent().getMenuCustomerServiceComponent().getCustomerServiceLinks();
            System.out.println("Customer Service Links:-------");
            for (WebElement link: customerServiceLinks
                 ) {
                System.out.println(link.getText());
            }

            List<WebElement> myAccountLinks = homePage.getFooterComponent().getMenuMyAccountComponent().getMyAccountLinks();
            System.out.println("My Account Links:-------");
            for (WebElement link: informationLinks
            ) {
                System.out.println(link.getText());
            }

            List<WebElement> followUsLinks = homePage.getFooterComponent().getMenuFollowUsComponent().getFollowUsLinks();
            System.out.println("Follow Us Links:-------");
            for (WebElement link: informationLinks
            ) {
                System.out.println(link.getText());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
