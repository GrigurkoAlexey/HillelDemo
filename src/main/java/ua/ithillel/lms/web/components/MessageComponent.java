package ua.ithillel.lms.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageComponent {

    private WebElement component;

    public MessageComponent(WebElement component) {
        this.component = component;
    }

    public MessageComponent addComment(String comment) {
        component.findElement(By.cssSelector(".feed-submit__form textarea")).sendKeys(comment);
        component.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        return this;
    }

    public String getCommentByValue(String value) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WebElement element : component.findElements(By.cssSelector(".comments__item"))) {
            String innerText = element.findElement(By.cssSelector(".comments__item-text")).getText().trim();
            if (innerText.equals(value))
                return innerText;
        }
        return "";
    }

    public MessageComponent deleteComment(String value) {
        for (WebElement element : component.findElements(By.cssSelector(".comments__item"))) {
            String innerText = element.findElement(By.cssSelector(".comments__item-text")).getText().trim();
            if (innerText.equals(value))
                element.findElement(By.cssSelector(".comments__item-btn--delete")).click();
        }
        return this;
    }
}
