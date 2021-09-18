package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuCustomerServiceComponent {
    public final WebDriver driver;

    public final By customerServiceSelector = By.cssSelector(".footer-menu-wrapper .customer-service ul a");

    public MenuCustomerServiceComponent(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCustomerServiceLinks() {
        return this.driver.findElements(customerServiceSelector);
    }
}
