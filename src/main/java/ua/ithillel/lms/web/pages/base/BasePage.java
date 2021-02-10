package ua.ithillel.lms.web.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {

    protected void navigateWithSideBar(WebDriver driver, SideBarItem type) {
        List<WebElement> sideBarElements = driver.findElements(By.cssSelector(".side-menu__item"));
        for (WebElement element : sideBarElements) {
            if (element.getText().trim().equals(type.getValue())) {
                element.click();
                return;
            }
        }
        sideBarElements.get(0).click();
    }

    public enum SideBarItem {
        HOME("Home"),
        FEED("Feed"),
        LESSONS("Lessons"),
        HW("HW");

        private String value;

        SideBarItem(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
