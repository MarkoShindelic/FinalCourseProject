package Tests;

import Base.BaseTest;
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
    public void userCanAddAllItemsToCart() {
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

    @Test
    public void removeAllItemsFromCart() {

        productPage.clickOnAddAllToCartButtons();

        String actualNumberOfCartItems = productPage.shoppingCartButton.getText();
        String expectedNumberOfCartItems = String.valueOf(productPage.removeButtons.size());

        Assert.assertEquals(actualNumberOfCartItems, expectedNumberOfCartItems);

        productPage.removeAllItemsFromCart();

        actualNumberOfCartItems = productPage.shoppingCartButton.getText();
        expectedNumberOfCartItems = "";

        Assert.assertEquals(actualNumberOfCartItems, expectedNumberOfCartItems);

        for (int i = 0; i < productPage.addToCartButton.size(); i++) {

            Assert.assertEquals(productPage.addToCartButton.get(i).getText(), "Add to cart");
        }

    }

    @Test
    public void userCanLogout(){

        productPage.clickOnBurgerMenuButton();
        sidebarPage.clickLogoutButton();

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";

        Assert.assertEquals(currentURL, expectedURL);
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());

    }

    @Test
    public void goToSpecificItemPage(){

        String expectedItem = "Sauce Labs Fleece Jacket";

        productPage.clickSpecificItem(expectedItem);

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=5";

        Assert.assertEquals(currentURL, expectedURL);

        String actualItem = inventoryItemPage.itemName.getText();
        Assert.assertEquals(actualItem, expectedItem);

        //inventoryItemPage.clickAddToCartButton();
    }

    @Test
    public void sortingProductsZToA(){

        productPage.selectItemFromDropdownMenu("za");
        //add some assertions

    }
}
