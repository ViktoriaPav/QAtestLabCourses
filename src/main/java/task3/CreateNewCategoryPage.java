package task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCategoryPage extends PageObject {

    @FindBy(id = "name_1")
    private WebElement fieldName;

    @FindBy(id = "meta_title_1")
    private WebElement metaTitle;

    @FindBy(id = "meta_description_1")
    private WebElement metaDescription;

    @FindBy(id = "category_form_submit_btn")
    private WebElement saveNewCategory;

    public void createNewCategory(String message) {
        fieldName.click();
        fieldName.sendKeys(message);
        saveNewCategory.click();
    }


    public CreateNewCategoryPage(WebDriver driver) {
        super(driver);
    }
}
