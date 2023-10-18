package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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

    @FindBy(className = "inventory_item_price")
    public List<WebElement> priceList;

    //*************************************************


    public void clickOnBurgerMenuButton() {
        burgerMenuButton.click();
    }

    public void clickOnAddAllToCartButtons() {
        for (WebElement b : addToCartButton) {
            b.click();
        }
    }

    public void removeAllItemsFromCart() {
        for (WebElement r : removeButtons) {
            r.click();
        }
    }

    public void selectItemFromDropdownMenu(String value) {
        Select objSelect = new Select(dropdownOptions);
        objSelect.selectByValue(value);
    }


    public void clickSpecificItem(String itemName) {

        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getText().equals(itemName)) {
                inventoryList.get(i).click();
            }
        }

    }

    public void clickOnCartButton() {
        shoppingCartButton.click();
    }


    public List<String> listOfProducts() {

        List<String> listOfProducts = new ArrayList<>();

        for (WebElement p : inventoryList) {
            listOfProducts.add(p.getText());
        }
        return listOfProducts;
    }

    public void addRandomItemToCart() {

        int min = 0;
        int max = inventoryList.size() - 1;

        int randomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);

        addToCartButton.get(randomNumber).click();


    }

    //Some utility methods
    public List<String> sortListZA(List<WebElement> inventoryList) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < inventoryList.size(); i++) {
            list.add(inventoryList.get(i).getText());
        }
        list.sort(Comparator.reverseOrder());
        return list;
    }

    public List<String> sortListAZ(List<WebElement> list) {

        List<String> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i).getText());
        }
        newList.sort(Comparator.naturalOrder());
        return newList;
    }

    public List<Double> sortListLowToHigh(List<WebElement> list) {

        List<Double> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            newList.add(Double.parseDouble(list.get(i).getText().replace("$", "")));
        }
        newList.sort(Comparator.naturalOrder());

        return newList;
    }

    public List<Double> sortListHighToLow(List<WebElement> list) {

        List<Double> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            newList.add(Double.parseDouble(list.get(i).getText().replace("$", "")));
        }
        newList.sort(Comparator.reverseOrder());

        return newList;
    }

}
