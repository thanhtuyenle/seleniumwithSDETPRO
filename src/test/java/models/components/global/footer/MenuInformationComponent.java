package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuInformationComponent {
    public final WebDriver driver;

    public final By informationSelector = By.cssSelector(".footer-menu-wrapper .information ul a");

    public MenuInformationComponent(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getInformationLinks() {
        return this.driver.findElements(informationSelector);
    }
}
