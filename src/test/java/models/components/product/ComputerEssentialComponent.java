package models.components.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.ComputerSpec;

public abstract class ComputerEssentialComponent {
    private final WebDriver driver;
    private final By addToCartBtn = By.cssSelector("[id^='add-to-cart-button']");

    public ComputerEssentialComponent(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void selectProcessorType(String type);
    public abstract void selectRamType(String type);

    public void selectHddType(String type) {
        selectCompSpecOption(type);
    }

    public void selectSoftwareType(String type) {
        selectCompSpecOption(type);
    }
    public void selectCompSpecOption(String option) {
        String optionValue =  ComputerSpec.valueOf(option).getValue();
        String selectorString = "//label[contains(text(), \"" + optionValue + "\")]";
        By optionSel = By.xpath(selectorString);
        driver.findElement(optionSel).click();

    }
    public void clickAddToCartButton() {
        WebElement eAddToCart = driver.findElement(addToCartBtn);
        eAddToCart.click();
    }
}
