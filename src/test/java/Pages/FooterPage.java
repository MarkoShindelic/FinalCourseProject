package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage extends BaseTest {

    public FooterPage() {

        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "Twitter")
    public WebElement twitterButton;

    @FindBy(linkText = "Facebook")
    public WebElement facebookButton;

    @FindBy(linkText = "LinkedIn")
    public WebElement linkedInButton;

    //**********************************

    public void clickOnFacebookButton(){
        facebookButton.click();
    }

    public void clickOnTwitterButton(){
        twitterButton.click();
    }

    public void clickOnLinkedInButton(){
        linkedInButton.click();
    }


}
