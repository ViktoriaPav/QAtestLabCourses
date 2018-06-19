package task5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task4.PageObject;
import task4.Product;

public class NewAddProductPage extends task5.PageObject {

    @FindBy(id = "form_step1_name_1")
    private WebElement nameNewProduct;

    @FindBy(id = "form_step1_qty_0_shortcut")
    private WebElement quantityNewProduct;

    @FindBy(id = "form_step1_price_shortcut")
    private WebElement priceNewProduct;

    @FindBy(className = "switch-input")
    private WebElement toggle;

    @FindBy(className = "growl-message")
    WebElement dynamicMessage;

    @FindBy(xpath = "//input[@class ='btn btn-primary save uppercase']")
    WebElement saveButton;

    @FindBy(xpath = "//*[@class = 'main-menu']/li[4]")
    WebElement menuCatalog;

    public void addNewProduct(Product product)  {
        nameNewProduct.sendKeys(product.getName());
        quantityNewProduct.sendKeys(String.valueOf(product.getQuantity()));
        priceNewProduct.clear();
        priceNewProduct.sendKeys(String.valueOf(product.getPrice()));
        toggle.click();
        validateMessage();
        activeSaveButton();
        validateMessage();
    }

    public void clickMenuCatalog(){
        menuCatalog.click();
    }

    public void activeSaveButton(){
       if(!saveButton.isDisplayed()){
           System.out.println("Save button is not displayed");
       } else {
           saveButton.click();
       }
    }

    public void validateMessage() {
        if (dynamicMessage.isDisplayed()) {
            System.out.println("Change saved");
        } else {
            System.out.println("Change have not save");
        }
    }

    public NewAddProductPage(WebDriver driver) {
        super(driver);
    }
}
