package core.element;

import org.openqa.selenium.WebDriver;

public class ActionBase {
    public ActionBase(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

}
