package ua.ithillel.lms.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.ithillel.lms.web.models.UserProfile;

import java.util.List;

public class ProfileComponent {
    private WebElement component;

    public ProfileComponent(WebElement component) {
        this.component = component;
    }

    public UserProfile getUserProfile() {
        UserProfile profile = new UserProfile();
        List<WebElement> elements = component.findElements(By.cssSelector("[class*=\"profile-simple-info__text\"]"));
        profile.setFirstName(elements.get(0).getText().trim().split(" ")[0]);
        profile.setLastName(elements.get(0).getText().trim().split(" ")[1]);
        profile.setAge(elements.get(1).getText().trim());
        profile.setEmail(elements.get(2).getText().trim());
        profile.setPhone(elements.get(3).getText().trim());
        return profile;
    }

    public void editProfile() { }

    public void logOut() { }
}
