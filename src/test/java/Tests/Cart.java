package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeClass;

public class Cart extends BaseTest {

    @BeforeClass
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");
    }



}
