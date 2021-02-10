package ua.ithillel.lms.base;

import org.openqa.selenium.WebDriver;
import ua.ithillel.infrastructure.WebDriverManager;
import ua.ithillel.infrastructure.utils.data.CookieParser;
import ua.ithillel.lms.web.WebClient;

public abstract class WebTestBase extends ApiTestBase {

    private WebDriver driver;
    private WebDriverManager driverManager;
    protected WebClient web;

    @Override
    protected final void beforeApiTestClass() {
        super.beforeApiTestClass();
        driverManager = new WebDriverManager();
        driver = driverManager.getBrowser();
        driver.get(config.getBaseUrl());
        driver.manage().addCookie(CookieParser.parseFromString(token));
        web = new WebClient(driver);
        beforeWebTests();
    }

    @Override
    protected final void afterApiTestClass() {
        afterWebTests();
        driverManager.realiseBrowser(driver);
        super.afterApiTestClass();
    }

    protected void beforeWebTests() {
    }

    protected void afterWebTests() {
    }

    @Override
    protected final void beforeApiTestMethod() {
        super.beforeApiTestMethod();
        driver.get(config.getBaseUrl());
        beforeWebTest();
    }

    @Override
    protected final void afterApiTestMethod() {
        afterWebTest();
        super.afterApiTestMethod();
    }

    protected void beforeWebTest() {
    }

    protected void afterWebTest() {
    }
}
