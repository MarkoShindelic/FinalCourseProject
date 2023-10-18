package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

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
    public void userCanVisitAllLinkedPages(){

        footerPage.clickOnTwitterButton();
        footerPage.clickOnFacebookButton();
        footerPage.clickOnLinkedInButton();

        ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabList.get(3));

        String expectedURL = "https://twitter.com/saucelabs";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);

        driver.switchTo().window(tabList.get(2));

        expectedURL = "https://www.facebook.com/saucelabs";
        actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);

        driver.switchTo().window(tabList.get(1));

        expectedURL = "https://www.linkedin.com/company/sauce-labs/";
        actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);

    }

}
