package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends BaseTest {


    @BeforeClass
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void UserCanLoginWithValidCredentials() {
        String validUsername = "standard_user";
        String validPassword = "secret_sauce";
        String currentURL = driver.getCurrentUrl();

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickLoginButton();


        String expectedURL = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(currentURL, expectedURL);
        Assert.assertTrue(productPage.pageTitle.isDisplayed());
        Assert.assertEquals(productPage.pageTitle.getText(), "Products");
    }

    @Test
    public void userCannotLoginWithEmptyUsername() {
        String invalidUsername = "";
        String invalidPassword = "secret_sauce";

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";


        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickLoginButton();

        Assert.assertEquals(currentURL, expectedURL);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String actualMessage = loginPage.errorMessage.getText();
        String expectedMessage = "Epic sadface: Username is required";

        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void userCannotLoginWithEmptyPassword() {
        String invalidUsername = "standard_user";
        String invalidPassword = "";

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";


        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickLoginButton();

        Assert.assertEquals(currentURL, expectedURL);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String actualMessage = loginPage.errorMessage.getText();
        String expectedMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void userCannotLoginWithInvalidCredentials() {
        String invalidUsername = "some user"; //Add Excel data here
        String invalidPassword = "some password"; //Add Excel data here

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";


        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickLoginButton();

        Assert.assertEquals(currentURL, expectedURL);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String actualMessage = loginPage.errorMessage.getText();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(actualMessage, expectedMessage);
    }

}


