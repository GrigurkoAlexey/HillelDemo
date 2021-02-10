package ua.ithillel.lms.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfirmModalComponent {

    private WebElement component;

    public ConfirmModalComponent(WebElement component) {
        this.component = component;
    }

    public void confirm() {
        component.findElement(By.cssSelector(".btn-yes")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel() {
        component.findElement(By.cssSelector(".btn-no")).click();
    }
}
