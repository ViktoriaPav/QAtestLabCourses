package task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends PageObject {

    @FindBy(css = ".img-thumbnail")
    private WebElement userProfile;

    @FindBy(id = "header_logout")
    private WebElement logout;

    @FindBy(id = "subtab-AdminCatalog")
    private WebElement menuCatalog;

    @FindBy(id = "subtab-AdminProducts")
    WebElement subMenuCatalogFirstProducts;

    @FindBy(id = "subtab-AdminCategories")
    private WebElement subMenuCatalogCategory;

    private WebElement dynElement = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id("subtab-AdminProducts")));

    public void clickOnSubMenuCatalogProduct() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(menuCatalog).pause(1000);
// проставить явное ожидание!!! Не хватает времени для определения локатора "Товары"
        actions.moveToElement(dynElement).click().build().perform();
    }

    public void clickOnCatalog(){
        menuCatalog.click();
    }

    public boolean logout() {
        userProfile.click();
        logout.click();
        return true;
    }

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
}
