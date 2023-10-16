package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;

    //********* Pages **********
    public LoginPage loginPage;
    public ProductPage productPage;
    public CartPage cartPage;
    public SidebarPage sidebarPage;
    public InventoryItemPage inventoryItemPage;
    public ExcelReader excelReader;


    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       // excelReader = new ExcelReader("/src/test/java/TestData.xlsx");

        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        sidebarPage = new SidebarPage();
        inventoryItemPage = new InventoryItemPage();


    }

}
