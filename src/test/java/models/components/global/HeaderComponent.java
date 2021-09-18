package models.components.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderComponent {
    private final WebDriver driver;
    private final By logoImageSelector = By.cssSelector(".header-logo img");
    private final By searchTextSelector = By.cssSelector("#small-searchterms");
    private final By searchButtonSelector = By.cssSelector("form[action=\"/search\"] .search-box-button");
    private final By headerLinksSelector = By.cssSelector(".header-links-wrapper ul a");

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement isHeaderLogoDisplayed() {
       return this.driver.findElement(logoImageSelector);
    }

    public List<WebElement> getAllHeaderLinks() {
        return this.driver.findElements(headerLinksSelector);
    }

    public void inputSearchItemThenClickSearch(String itemName) {
        this.inputSearchItem(itemName);
        this.clickOnSearchButton();
    }

    public void inputSearchItem(String itemName) {
        this.driver.findElement(searchTextSelector).sendKeys(itemName);
    }
    public void clickOnSearchButton(){
        this.driver.findElement(searchButtonSelector).click();
    }

}
