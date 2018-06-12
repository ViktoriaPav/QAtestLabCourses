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

    @FindBy(css = "ps_back-office .title")
    WebElement subMenuCatalogFirstGoods;

    @FindBy(linkText = "/admin147ajyvk0/index.php/product/catalog?_token=2ChAmxscOp-yxA4NwvHOYsqOqVwNDRcvmtqz64c_zQM")
    private WebElement subMenuCatalogCategory;

    /*
    <a href="http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminCategories&amp;token=795a6350b3a0f87af2a165b4c1a34372" class="title">
															категории														</a>

        <a href="/admin147ajyvk0/index.php/product/catalog?_token=2ChAmxscOp-yxA4NwvHOYsqOqVwNDRcvmtqz64c_zQM" class="title has_submenu">
                                            <i class="material-icons">store</i>
                                            <span>
        Каталог										</span>
                                        </a>
    */
    public void clickOnCatalogCategory() {
        Actions builder = new Actions(driver);

        builder.moveToElement(menuCatalog);
        builder.moveToElement(subMenuCatalogFirstGoods);
        builder.moveToElement(subMenuCatalogCategory);
        builder.click().perform();

    }

    public void clickOnMenuCatalog() {
        menuCatalog.click();
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
