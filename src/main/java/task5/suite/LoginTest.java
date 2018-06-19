package task5.suite;

import org.testng.annotations.Test;
import task4.LoginPage;
import task4.Variables;


public class LoginTest extends FunctionalTest {


    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        loginPage.login(Variables.LOGIN, Variables.PASSWORD);
        ;
        assertEquals(driver.getTitle(), "prestashop-automation > Панель администратора (PrestaShop™)");
        // необходимо отловить сообщение или загруженную страницу для проверки
        System.out.println(driver.getTitle());

    }
}
