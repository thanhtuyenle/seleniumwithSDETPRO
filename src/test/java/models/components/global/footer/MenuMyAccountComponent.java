package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuMyAccountComponent {
    public final WebDriver driver;

    public final By myAccountSelector = By.cssSelector(".footer-menu-wrapper .my-account ul a");

    public MenuMyAccountComponent(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getMyAccountLinks() {
        return this.driver.findElements(myAccountSelector);
    }
}
