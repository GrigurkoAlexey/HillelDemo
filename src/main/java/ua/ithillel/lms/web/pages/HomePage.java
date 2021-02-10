package ua.ithillel.lms.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ithillel.lms.web.components.ProfileComponent;
import ua.ithillel.lms.web.pages.base.BasePage;

public class HomePage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("app-profile-simple")));
    }

    public FeedPage getFeedPage() {
        navigateWithSideBar(driver, SideBarItem.FEED);
        return new FeedPage(driver, wait);
    }

    public LessonsPage getLessonsPage() {
        navigateWithSideBar(driver, SideBarItem.LESSONS);
        return new LessonsPage(driver, wait);
    }

    public HomeWorksPage getHomeWorksPage() {
        navigateWithSideBar(driver, SideBarItem.HW);
        return new HomeWorksPage(driver, wait);
    }

    public ProfileComponent getProfileComponent() {
        return new ProfileComponent(driver.findElement(By.cssSelector("app-profile-simple")));
    }
}
