package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    @FindBy(className = "product_sort_container")
    public WebElement dropdownOptions;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> inventoryList;

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

    public void selectItemFromDropdownMenu(String value){
        Select objSelect = new Select(dropdownOptions);
        objSelect.selectByValue(value);
    }


    public void clickSpecificItem(String itemName){

        for (int i = 0; i < inventoryList.size(); i++) {
            if(inventoryList.get(i).getText().equals(itemName)){
                inventoryList.get(i).click();
            }
        }

    }


    //Some utility methods
    public List<String> listOfProducts(){

        List<String> listOfProducts = new ArrayList<>();

        for(WebElement p: inventoryList){
            listOfProducts.add(p.getText());
        }
        return listOfProducts;
    }

    public List<String> sortedListZA(List<String> list){

        list = listOfProducts();
        list.sort(Comparator.reverseOrder());
        return list;

    }

}
