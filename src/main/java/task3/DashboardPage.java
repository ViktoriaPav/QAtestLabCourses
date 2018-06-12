package task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static javafx.scene.input.KeyCode.T;

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


    public void clickOnCatalogCategory() {
        Actions builder = new Actions(driver);
        builder.moveToElement(menuCatalog);
        builder.moveToElement(subMenuCatalogFirstProducts);
        builder.moveToElement(subMenuCatalogCategory).click().build().perform();
    }

    public boolean logout() {
        Helper.clickOn(userProfile);
        Helper.clickOn(logout);
        return true;
    }

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
}
