package task5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends task5.PageObject {

    @FindBy(id = "page-header-desc-configuration-add")
    WebElement newProductButton;

    @FindBy(xpath = "//tr/td[3]")
    WebElement columnName;

    @FindBy(xpath = "//tr/td[6]")
    WebElement columnPrice;

    @FindBy(xpath = "//tr/td[7]")
    WebElement columnQuantity;

    @FindBy(name = "filter_column_name")
    WebElement nameFilterField;

    @FindBy(name = "products_filter_submit")
    WebElement productFilterButton;

    @FindBy(name = "filter_column_name_category")
    WebElement categoryFilterField;



    public void clickOnNewProductButton() {
        newProductButton.click();
    }

    public void filterProduct(Product product) {
        nameFilterField.clear();
        nameFilterField.sendKeys(product.getName());
        categoryFilterField.sendKeys("");
        WebElement dynamicFilterButton = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(productFilterButton));
        dynamicFilterButton.click();


    }
public Product firstProduct(){
    Product filterProduct = new Product(columnName.getText(), Integer.valueOf(columnQuantity.getText()), Double.parseDouble(columnPrice.getText().replace(",", ".").replace("₴", "")));
    return filterProduct;
}

    public List<Product> getAllProductsOnThePage() {
        List<WebElement> allId = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> allName = driver.findElements(By.xpath("//tr/td[3]"));
        List<WebElement> allPrice = driver.findElements(By.xpath("//tr/td[6]"));
        List<WebElement> allQuantity = driver.findElements(By.xpath("//tr/td[7]"));

        List<Product> allProductOnThePage = new ArrayList<Product>();

        for (int i = 0; i < allName.size() - 1; i++) {
            allProductOnThePage.add(new Product(Integer.valueOf(allId.get(i).getText()), allName.get(i).getText(), Integer.valueOf(allQuantity.get(i).getText()), Double.parseDouble(allPrice.get(i).getText().replace("₴", "").replace(",", "."))));
        }
        System.out.println(allProductOnThePage);
        return allProductOnThePage;
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
