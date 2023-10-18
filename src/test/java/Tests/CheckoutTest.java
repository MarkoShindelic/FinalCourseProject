package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanCheckoutCartItems(){

        String validUsername = "standard_user";
        String validPassword = "secret_sauce";

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickLoginButton();

        String expectedNumberOfCartItems = "";
        Assert.assertEquals(expectedNumberOfCartItems, productPage.shoppingCartButton.getText());

        productPage.addRandomItemToCart();
        productPage.addRandomItemToCart();
        productPage.addRandomItemToCart();

        productPage.clickOnCartButton();

        String actualNumberOfCartItems = productPage.shoppingCartButton.getText();
        expectedNumberOfCartItems = String.valueOf(cartPage.removeButtons.size());
        Assert.assertEquals(actualNumberOfCartItems, expectedNumberOfCartItems);

        cartPage.clickOnCheckoutButton();
        String name = "John";
        String lastName = "Smith";
        String postalCode = "11000";

        checkoutStepOnePage.inputFirstName(name);
        checkoutStepOnePage.inputLastName(lastName);
        checkoutStepOnePage.inputPostalCode(postalCode);

        checkoutStepOnePage.clickContinueButton();

        String actualPrice = checkoutStepTwoPage.getItemSum();
        String expectedPrice = checkoutStepTwoPage.getTotalPrice();

        Assert.assertEquals(actualPrice, expectedPrice);

        actualPrice = String.valueOf(checkoutStepTwoPage.getProductsSumWithTax());
        expectedPrice = checkoutStepTwoPage.getTotal();

        Assert.assertEquals(actualPrice, expectedPrice);

        checkoutStepTwoPage.clickFinishButton();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/checkout-complete.html";

        Assert.assertEquals(actualURL, expectedURL);

        String actualMessage = checkoutCompletePage.getThankYouMessageText();
        String expectedMessage = "Thank you for your order!";

        Assert.assertEquals(actualMessage, expectedMessage);

        actualMessage = checkoutCompletePage.getOrderDispatchedMessage();
        expectedMessage = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

        Assert.assertEquals(actualMessage, expectedMessage);

        Assert.assertTrue(checkoutCompletePage.BackHomeButton.isDisplayed());

    }


}
