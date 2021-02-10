package ua.ithillel.infrastructure.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.ithillel.infrastructure.config.ConfigurationManager;
import ua.ithillel.infrastructure.enums.WebDriverType;

public class LocalWebDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create() {
        WebDriverType type = ConfigurationManager.getInstance().getWebDriverType();
        switch (type) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new RuntimeException(type + " type is not supported");
        }
    }
}
