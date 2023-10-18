package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
    public List<WebElement> removeButtons;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(className = "cart_item")
    public List<WebElement> cartItems;
    
    //******************************************************************

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }
    
    public void clickOnAllRemoveButtons(){

        for (WebElement b:removeButtons) {
            b.click();
        }
        
    }

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }

}
