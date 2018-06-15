package Task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public boolean logout() {
        userProfile.click();
        logout.click();
        return true;
    }

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
}
