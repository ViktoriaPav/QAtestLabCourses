package task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPageBeforeLogging extends PageObject {

    @FindBy(className = "ui-autocomplete-input")
    WebElement searchField;

    @FindBy(xpath = "//form/button/i")
    WebElement searchFiealdButton;

    @FindBy(className = "product-title")
    WebElement titleProduct;

    @FindBy(xpath = "//*[@class = 'nav-item'][2]")
    WebElement moreAboutProduct;





    public void searchProduct(Product product){
        searchField.clear();
        searchField.sendKeys(product.getName());
        searchFiealdButton.click();
        titleProduct.click();

    }

    public ProductsPageBeforeLogging(WebDriver driver) {
        super(driver);
    }
}
