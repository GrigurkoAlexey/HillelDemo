package ua.ithillel.lms.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ithillel.lms.web.pages.AuthPage;
import ua.ithillel.lms.web.pages.HomePage;

public class WebClient {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebClient(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3000);
    }

    public AuthPage getAuthPage() {
        return new AuthPage(driver, wait);
    }

    public HomePage getMainPage() {
        return new HomePage(driver, wait);
    }

    public void clearCookies() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}
