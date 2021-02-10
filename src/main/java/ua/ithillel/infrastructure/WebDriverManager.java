package ua.ithillel.infrastructure;

import org.openqa.selenium.WebDriver;
import ua.ithillel.infrastructure.config.ConfigurationManager;
import ua.ithillel.infrastructure.enums.RunOn;
import ua.ithillel.infrastructure.factory.LocalWebDriverFactory;
import ua.ithillel.infrastructure.factory.RemoteWebDriverFactory;
import ua.ithillel.infrastructure.factory.WebDriverFactory;

public class WebDriverManager {

    public WebDriver getBrowser() {
        RunOn runOn = ConfigurationManager.getInstance().getRunOn();
        WebDriverFactory factory;

        switch (runOn) {
            case LOCAL:
                factory = new LocalWebDriverFactory();
                break;
            case REMOTE:
                factory = new RemoteWebDriverFactory();
                break;
            default:
                throw new RuntimeException(runOn + " invalid environment");
        }
        return factory.create();
    }

    public void realiseBrowser(WebDriver driver) {
        if (driver != null)
            driver.quit();
    }
}
