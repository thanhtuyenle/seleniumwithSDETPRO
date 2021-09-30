package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailsPage {
    private final WebDriver driver;
    private final By barNotificationContentSel = By.cssSelector("#bar-notification p");
    private final By barNotificationContentLinkSel = By.cssSelector("#bar-notification p a");

    public ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBarNotificationContentSel() {
        return driver.findElement(barNotificationContentSel).getText();
    }

    public String getBarNotificationContentLinkSel() {
        return driver.findElement(barNotificationContentLinkSel).getAttribute("href");
    }

    public boolean isMyItemAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            String content = "The product has been added to your shopping cart";
            wait.until(ExpectedConditions.textToBePresentInElementLocated(barNotificationContentSel, content));
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public void waitUntilItemAddedToCart(){
        isMyItemAddedToCart();
    }
}
