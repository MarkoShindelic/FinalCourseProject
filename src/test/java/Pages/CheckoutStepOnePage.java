package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutStepOnePage extends BaseTest {


    public CheckoutStepOnePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(id = "continue")
    public WebElement continueButton;


    //*********************************************

    public void inputFirstName(String name){
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }

    public void inputLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputPostalCode(String code){
        postalCodeField.clear();
        postalCodeField.sendKeys(code);
    }

    public void clickContinueButton(){
        continueButton.click();
    }


}
