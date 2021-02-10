package ua.ithillel.lms.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FeedComponent {

    private WebElement component;

    public FeedComponent(WebElement component) {
        this.component = component;
    }

    public List<MessageComponent> getMessages() {
        List<MessageComponent> messages = new ArrayList<>();
        component.findElements(By.cssSelector(".feed-post")).forEach(item -> messages.add(new MessageComponent(item)));
        return messages;
    }

    public MessageComponent getMessageByIndex(int index) {
        try {
            return getMessages().get(index);
        } catch (RuntimeException ex) {
            throw new RuntimeException("There are no such message at index " + index);
        }
    }
}
