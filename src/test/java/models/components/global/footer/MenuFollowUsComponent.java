package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuFollowUsComponent {
    public final WebDriver driver;

    public final By followUsSelector = By.cssSelector(".footer-menu-wrapper .follow-us ul a");

    public MenuFollowUsComponent(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getFollowUsLinks() {
        return this.driver.findElements(followUsSelector);
    }
}
