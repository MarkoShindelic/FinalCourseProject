package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Products extends BaseTest {

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
    public void userCanAddAllItemsToCart(){
        String expectedNumberOfCartItems = "";

        Assert.assertTrue(productPage.shoppingCartButton.isDisplayed());
        Assert.assertEquals(expectedNumberOfCartItems, productPage.shoppingCartButton.getText()); //Check to see if cart is empty

        productPage.clickOnAddAllToCartButtons();

        expectedNumberOfCartItems = String.valueOf(productPage.removeButtons.size());

        Assert.assertEquals(productPage.shoppingCartBadge.getText(), expectedNumberOfCartItems);

        for (int i = 0; i < productPage.removeButtons.size(); i++) {

            Assert.assertEquals(productPage.removeButtons.get(i).getText(), "Remove");
        }

    }
}
