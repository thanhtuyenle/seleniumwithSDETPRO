package models.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TheSecurePage {
    private final WebDriver driver;

    private By titleHeaderSelector = By.tagName("h2");
    public TheSecurePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitleText() {

        return driver.findElement(titleHeaderSelector).getText();

    }

    public void verifyUserIsOnSecurePage() {
        final String expectedTitle = "Secure Area";
        String currentTitle = getTitleText();

        if(!currentTitle.equals(expectedTitle))
            System.out.println("Current title is not as same as expected title");
    }

}
