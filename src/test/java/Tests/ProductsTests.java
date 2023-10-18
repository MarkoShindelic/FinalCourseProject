package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTests extends BaseTest {

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

        productPage.clickOnCartButton();
        String expectedURL = "https://www.saucedemo.com/cart.html";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(productPage.shoppingCartBadge.getText(), expectedNumberOfCartItems);

        Assert.assertTrue(cartPage.continueShoppingButton.isDisplayed());
        Assert.assertTrue(cartPage.checkoutButton.isDisplayed());


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
    public void userCanLogout() {

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
    public void goToSpecificItemPage() {

        String expectedItem = "Sauce Labs Fleece Jacket";

        productPage.clickSpecificItem(expectedItem);

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=5";

        Assert.assertEquals(currentURL, expectedURL);

        String actualItem = inventoryItemPage.itemName.getText();
        Assert.assertEquals(actualItem, expectedItem);

    }

    @Test
    public void addSpecificItemToCart() {

        String expectedItem = "Sauce Labs Fleece Jacket";

        productPage.clickSpecificItem(expectedItem);

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=5";

        Assert.assertEquals(currentURL, expectedURL);

        String actualItem = inventoryItemPage.itemName.getText();
        Assert.assertEquals(actualItem, expectedItem);

        inventoryItemPage.clickAddToCartButton();
    }

    @Test
    public void addAnItemToCart() {

        productPage.addRandomItemToCart();

        String actualNumberOfCartItems = productPage.shoppingCartButton.getText();
        String expectedNumberOfCartItems = String.valueOf(productPage.removeButtons.size());

        Assert.assertEquals(actualNumberOfCartItems, expectedNumberOfCartItems);
        Assert.assertEquals(productPage.shoppingCartBadge.getText(), expectedNumberOfCartItems);

        productPage.clickOnCartButton();

        Assert.assertEquals(String.valueOf(cartPage.cartItems.size()), "1");

    }

    @Test
    public void sortingProductsZToA() {

        productPage.selectItemFromDropdownMenu("za");

        List<String> list = productPage.sortListZA(productPage.inventoryList);

        for (int i = 0; i < list.size(); i++) {

            Assert.assertEquals(list.get(i), productPage.listOfProducts().get(i));

        }
    }

    @Test
    public void sortingProductsAToZ() {

        productPage.selectItemFromDropdownMenu("hilo");
        productPage.selectItemFromDropdownMenu("az");

        List<String> list = productPage.sortListAZ(productPage.inventoryList);

        for (int i = 0; i < list.size(); i++) {

            Assert.assertEquals(list.get(i), productPage.listOfProducts().get(i));

        }
    }

    @Test
    public void sortingProductsPriceHighToLow() {

        productPage.selectItemFromDropdownMenu("hilo");
        //add some assertions
        List<Double> list = productPage.sortListHighToLow(productPage.priceList);


        for (int i = 0; i < list.size(); i++) {

            Assert.assertEquals(list.get(i), Double.parseDouble(productPage.priceList.get(i).getText().replace("$", "")));

        }
    }

    @Test
    public void sortingProductsLowToHigh() {

        productPage.selectItemFromDropdownMenu("lohi");

        List<Double> list = productPage.sortListLowToHigh(productPage.priceList);


        for (int i = 0; i < list.size(); i++) {

            Assert.assertEquals(list.get(i), Double.parseDouble(productPage.priceList.get(i).getText().replace("$", "")));
        }
    }


}
