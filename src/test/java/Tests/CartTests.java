package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @BeforeMethod
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");

        String validUsername = "standard_user";
        String validPassword = "secret_sauce";


        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickLoginButton();
    }

    @Test
    public void userCanReturnToProductsPage(){

        productPage.addRandomItemToCart();
        productPage.clickOnCartButton();
        cartPage.clickOnContinueShoppingButton();

        String expectedNumberOfCartItems = String.valueOf(productPage.removeButtons.size());
        String actualNumberOfCartItems = productPage.shoppingCartBadge.getText();

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualNumberOfCartItems, expectedNumberOfCartItems);
        Assert.assertEquals(actualURL, expectedURL);


    }



}
