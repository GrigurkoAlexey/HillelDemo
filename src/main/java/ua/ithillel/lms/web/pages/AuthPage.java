package ua.ithillel.lms.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AuthPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".login")));
    }

    public AuthPage fillEmail(String email) {
        driver.findElement(By.cssSelector(".login  input[type=\"email\"]")).sendKeys(email);
        return this;
    }

    public AuthPage fillPassword(String password) {
        driver.findElement(By.cssSelector(".login  input[type=\"password\"]")).sendKeys(password);
        return this;
    }

    public void signIn() {
        driver.findElement(By.cssSelector(".access__button button")).click();
    }
}
