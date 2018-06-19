package task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id="email")
    private WebElement login;

    @FindBy(name="passwd")
    private WebElement password;

    @FindBy(name="submitLogin")
    private WebElement loginButton;


    public void login (String email, String password){
        login.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
