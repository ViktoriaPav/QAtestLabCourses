package task5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task4.PageObject;

public class HomePage extends task5.PageObject {


    @FindBy(className = "all-product-link")
    private WebElement allProductsButton;

    public void clickAllProductsButton() {
        WebElement dynamicButton = (new WebDriverWait(driver,15)).until(ExpectedConditions.presenceOfElementLocated(By.className("all-product-link")));
        dynamicButton.click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
