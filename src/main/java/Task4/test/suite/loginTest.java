package Task4.test.suite;

import Task4.LoginPage;
import Task4.Variables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class loginTest extends FunctionalTest {



    @Test
    public void LoginTest (){
        LoginPage loginPage = new LoginPage(driver);

        if(driver!=null){
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        loginPage.login(Variables.LOGIN,Variables.PASSWORD);
        // необходимо отловить сообщение или загруженную страницу для проверки
        driver.getTitle();
        System.out.println(driver.getTitle());
    }else {
            System.out.println("Ошибка");
        }
    }

}
