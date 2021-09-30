package tests.order;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.ComputerDataObject;
import testflows.computer.OrderingComputerFlow;
import tests.BaseTest;
import utils.data.ComputerTestDataGenerator;

public class BuildStandardComputerTest extends BaseTest {

    @Test(dataProvider = "standardComputerDataSet")
    public void testBuildingCheapComputer(ComputerDataObject computerDataObject) {
        WebDriver driver = getDriver();
        OrderingComputerFlow orderingComputerFlow = new OrderingComputerFlow(driver);
        driver.get("http://demowebshop.tricentis.com/build-your-own-computer");

        orderingComputerFlow.buildStandardComputer(computerDataObject);
        driver.get("http://demowebshop.tricentis.com/cart");
        orderingComputerFlow.verifyComputerAdded(computerDataObject);
    }


    @DataProvider
    public ComputerDataObject[] standardComputerDataSet() {
        ComputerDataObject[] computerDataObjects = ComputerTestDataGenerator
                .getTestDataFrom("/src/test/java/testdata/StandardComputerDataList.json");
        return computerDataObjects;
    }
}
