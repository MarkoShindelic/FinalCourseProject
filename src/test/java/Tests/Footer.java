package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Footer extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
        String validUsername = "standard_user";
        String validPassword = "secret_sauce";


        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickLoginButton();
    }

    @Test
    public void userCanVisitTwitterPage() {

        footerPage.clickOnTwitterButton();

        String expectedURL = "https://twitter.com/saucelabs";
        String actualURL = footerPage.twitterButton.getAttribute("href");

        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test
    public void userCanVisitFacebookPage() {

        footerPage.clickOnFacebookButton();

        String expectedURL = "https://www.facebook.com/saucelabs";
        String actualURL = footerPage.facebookButton.getAttribute("href");

        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test
    public void userCanVisitLinkedInPage() {

        footerPage.clickOnLinkedInButton();

        String expectedURL = "https://www.linkedin.com/company/sauce-labs/";
        String actualURL = footerPage.linkedInButton.getAttribute("href");

        Assert.assertEquals(actualURL, expectedURL);

    }

}
