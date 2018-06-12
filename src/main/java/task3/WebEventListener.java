package task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {

    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Before navigating to: '" + s + "'");

    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigated to:'" + s + "'");
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Navigated forward to next page");
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Found Element By : " + by.toString());
    }

    public void beforeClickOn(WebElement element, WebDriver webDriver) {
        System.out.println("Trying to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver webDriver) {
        System.out.println("Clicked on: " + element.toString());
    }

    public void beforeChangeValueOf(WebElement element, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value of the:" + element.toString()
                + " before any changes made");
    }

    public void afterChangeValueOf(WebElement element, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Element value changed to: " + element.toString());
    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception occured: " + throwable);
    }
}
