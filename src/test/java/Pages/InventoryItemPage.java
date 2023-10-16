package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage extends BaseTest {

    public InventoryItemPage() {

        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".inventory_details_name.large_size")
    public WebElement itemName;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public WebElement addToCartButton;


    //**************************************

    public String getItemNameText(){

        return itemName.getText();
    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }

}
