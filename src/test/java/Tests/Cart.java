package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Cart extends BaseTest {

    @BeforeClass
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test



}
