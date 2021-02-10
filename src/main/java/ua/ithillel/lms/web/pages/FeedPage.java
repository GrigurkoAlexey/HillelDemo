package ua.ithillel.lms.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ithillel.lms.web.components.ConfirmModalComponent;
import ua.ithillel.lms.web.components.FeedComponent;
import ua.ithillel.lms.web.pages.base.BasePage;

public class FeedPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FeedPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".feed-student")));
    }

    public FeedComponent getFeedComponent() {
        return new FeedComponent(driver.findElement(By.cssSelector(".feed-student")));
    }

    public ConfirmModalComponent getConfirmModalComponent() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id*=\"mat-dialog\"]")));
        return new ConfirmModalComponent(driver.findElement(By.cssSelector("[id*=\"mat-dialog\"]")));
    }
}
