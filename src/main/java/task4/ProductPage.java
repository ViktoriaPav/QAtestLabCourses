package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends PageObject {

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

    public void clickOnNewProductButton() {
        newProductButton.click();
    }

    public Product filterProduct(Product product) {
        nameFilterField.sendKeys(product.getName());
        nameFilterField.sendKeys(Keys.ENTER);
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
