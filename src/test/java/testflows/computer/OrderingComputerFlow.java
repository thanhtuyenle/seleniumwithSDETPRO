package testflows.computer;

import models.pages.cart.ShoppingCartPage;
import models.pages.computer.CheapComputerItemDetailsPage;
import models.pages.computer.StandardComputerItemDetailsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testdata.ComputerDataObject;
import testdata.ComputerSpec;

public class OrderingComputerFlow {
    private final WebDriver driver;

    public OrderingComputerFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void buildCheapComputer(ComputerDataObject computerDataObject) {
        CheapComputerItemDetailsPage cheapComputerItemDetailsPage = new CheapComputerItemDetailsPage(driver);

        cheapComputerItemDetailsPage.cheapComputerEssentialComponent().selectProcessorType(computerDataObject.getProcessorType());
        cheapComputerItemDetailsPage.cheapComputerEssentialComponent().selectRamType(computerDataObject.getRam());
        cheapComputerItemDetailsPage.cheapComputerEssentialComponent().selectHddType(computerDataObject.getHdd());

        cheapComputerItemDetailsPage.cheapComputerEssentialComponent().clickAddToCartButton();
        try {
            cheapComputerItemDetailsPage.isMyItemAddedToCart();
        }catch (Exception e) {
            throw new Error("[ERR] Item is not added after 15s!");
        }
    }

    public void buildStandardComputer(ComputerDataObject computerDataObject) {
        StandardComputerItemDetailsPage cheapComputerItemDetailsPage = new StandardComputerItemDetailsPage(driver);

        cheapComputerItemDetailsPage.standardEssentialComponent().selectProcessorType(computerDataObject.getProcessorType());
        cheapComputerItemDetailsPage.standardEssentialComponent().selectRamType(computerDataObject.getRam());
        cheapComputerItemDetailsPage.standardEssentialComponent().selectHddType(computerDataObject.getHdd());

        cheapComputerItemDetailsPage.standardEssentialComponent().clickAddToCartButton();
        try {
            cheapComputerItemDetailsPage.isMyItemAddedToCart();
        }catch (Exception e) {
            throw new Error("[ERR] Item is not added after 15s!");
        }
    }

    public void verifyComputerAdded(ComputerDataObject simpleComputer) {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        // Get fixed price for this computer type
        final double fixedPrice = 800.0;

        // Get additional fee
        double additionalFees = 0.0;
        additionalFees += ComputerSpec.valueOf(simpleComputer.getProcessorType()).getAdditionalPrice();
        additionalFees += ComputerSpec.valueOf(simpleComputer.getRam()).getAdditionalPrice();
        additionalFees += ComputerSpec.valueOf(simpleComputer.getHdd()).getAdditionalPrice();

        // Get Total current price for computer
        double currentCompPrice = fixedPrice + additionalFees;

        // Compare
        double itemTotalPrice = shoppingCartPage.shoppingCartItemComponent().itemTotalPrice();
        Assert.assertEquals(itemTotalPrice, currentCompPrice, "[ERR] Total price is not correct!");
    }
}
