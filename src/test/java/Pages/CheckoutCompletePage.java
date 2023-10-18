package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BaseTest {

    public CheckoutCompletePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "back-to-products")
    public WebElement BackHomeButton;

    @FindBy(className = "complete-header")
    public WebElement thankYouMessage;

    @FindBy(className = "complete-text")
    public WebElement orderDispatchedMessage;

    public String getThankYouMessageText(){
        return thankYouMessage.getText();
    }

    public String getOrderDispatchedMessage(){
        return orderDispatchedMessage.getText();
    }
}
