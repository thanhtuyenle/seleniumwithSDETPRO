package models.components.global;

import models.components.global.footer.MenuCustomerServiceComponent;
import models.components.global.footer.MenuFollowUsComponent;
import models.components.global.footer.MenuInformationComponent;
import models.components.global.footer.MenuMyAccountComponent;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class FooterComponent {
    private final WebDriver driver;

    public MenuCustomerServiceComponent menuCustomerServiceComponent;
    public MenuInformationComponent menuInformationComponent;
    public MenuMyAccountComponent menuMyAccountComponent;
    public MenuFollowUsComponent menuFollowUsComponent;

    public FooterComponent(WebDriver driver) {
        this.driver = driver;
    }

    public MenuCustomerServiceComponent getMenuCustomerServiceComponent() {
        return new MenuCustomerServiceComponent(driver);
    }

    public MenuInformationComponent getMenuInformationComponent() {
        return new MenuInformationComponent(driver);
    }

    public MenuMyAccountComponent getMenuMyAccountComponent() {
        return new MenuMyAccountComponent(driver);
    }

    public MenuFollowUsComponent getMenuFollowUsComponent() {
        return new MenuFollowUsComponent(driver);
    }
}
