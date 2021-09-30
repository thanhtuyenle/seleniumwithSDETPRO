package models.pages.cart;

import models.components.cart.ShoppingCartItemComponent;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private final WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShoppingCartItemComponent shoppingCartItemComponent() {
        return new ShoppingCartItemComponent(driver);
    }
}
