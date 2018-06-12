package task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Category extends PageObject {

    @FindBy(className = "process-icon-new")
    private WebElement addNewCategory;

    @FindBy(className = "alert-success")
    private WebElement successfulMessage;

    @FindBy(name = "categoryFilter_name")
    private WebElement categoryFilter;

    @FindBy(id = "submitFilterButtoncategory")
    private WebElement submitFilterButtonCategory;



    public void filterCategory(String name){
        categoryFilter.sendKeys(name);
        submitFilterButtonCategory.click();
    }

    public boolean verifyMessage() {
        String message = successfulMessage.getText();
        if (message.contains("Создано")) {
            System.out.println("true" + message);
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    public void addNewCategory() {
        addNewCategory.click();
    }

    public Category(WebDriver driver) {
        super(driver);
    }
}
