package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutStepTwoPage extends BaseTest {

    public CheckoutStepTwoPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "inventory_item_price")
    public List<WebElement> priceList;

    @FindBy(css = ".summary_info_label.summary_total_label")
    public WebElement totalPriceWithTax;

    @FindBy(className = "summary_subtotal_label")
    public WebElement totalPrice;

    @FindBy(className = "summary_tax_label")
    public WebElement tax;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(css = ".summary_info_label.summary_total_label")
    public WebElement total;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    //**********************************************

    public String getTotal() {
        return total.getText().replace("Total: $", "");
    }

    public String getTotalPrice() {
        return totalPrice.getText().replace("Item total: $", "");
    }

    public String getItemSum() {
        return String.valueOf(productsSum(priceList));
    }

    public String getTaxValue() {

        return tax.getText().replace("Tax: $", "");
    }

    public Double getProductsSumWithTax() {

        Double temp = Double.valueOf(getTaxValue());

        Double sum = productsSum(priceList) + temp;
        return sum;
    }

    public void clickFinishButton() {
        finishButton.click();
    }


    //Utility
    public double productsSum(List<WebElement> list) {

        double sum = 0;
        ArrayList<Double> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            newList.add(Double.valueOf(list.get(i).getText().replace("$", "")));
        }

        for (Double d : newList) {
            sum += d;
        }

        return Math.floor(sum * 100) / 100;
    }


}
