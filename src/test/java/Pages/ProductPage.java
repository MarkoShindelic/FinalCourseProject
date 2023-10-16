package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductPage extends BaseTest {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement pageTitle;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory ")
    public List<WebElement> addToCartButton;

    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory ")
    public List<WebElement> removeButtons;

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCartButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartBadge;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuButton;

    //*************************************************

    public void clickOnBurgerMenuButton(){
        burgerMenuButton.click();
    }

    public void clickOnAddAllToCartButtons(){
        for(WebElement b: addToCartButton){
            b.click();
        }
    }

    public void removeAllItemsFromCart(){
        for(WebElement r: removeButtons){
            r.click();
        }
    }

}
