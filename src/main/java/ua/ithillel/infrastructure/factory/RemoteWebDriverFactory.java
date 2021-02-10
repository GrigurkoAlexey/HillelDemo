package ua.ithillel.infrastructure.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import ua.ithillel.infrastructure.config.ConfigurationManager;
import ua.ithillel.infrastructure.enums.WebDriverType;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create() {
        WebDriverType type = ConfigurationManager.getInstance().getWebDriverType();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (type) {
            case CHROME:
                capabilities.setBrowserName("chrome");
                break;
            case FIREFOX:
                capabilities.setBrowserName("firefox");
                break;
        }
        return startRemoteWebDriver(capabilities);
    }

    private WebDriver startRemoteWebDriver(DesiredCapabilities capabilities) {
        try {
            RemoteWebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            webDriver.setFileDetector(new LocalFileDetector());
            return webDriver;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to create Remote Driver");
        }
    }

}
