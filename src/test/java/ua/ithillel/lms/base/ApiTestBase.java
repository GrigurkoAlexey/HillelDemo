package ua.ithillel.lms.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ua.ithillel.infrastructure.config.ConfigurationManager;
import ua.ithillel.infrastructure.utils.logger.ConsoleLogger;
import ua.ithillel.lms.api.ApiClient;
import ua.ithillel.lms.api.controllers.AuthorizeController;


public abstract class ApiTestBase {

    protected ConfigurationManager config = ConfigurationManager.getInstance();
    protected ConsoleLogger logger = new ConsoleLogger();
    protected String token;
    protected ApiClient api;

    @BeforeClass
    public final void beforeApiClass() {
        AuthorizeController auth = new AuthorizeController();
        token = auth.authorize(config.getUser()).getHeader("Set-Cookie");
        RequestSpecification specification = RestAssured.given()
                .baseUri(config.getBaseUrl())
                .header("Origin", config.getBaseUrl())
                .header("Referer", config.getBaseUrl())
                .header("Cookie", token)
                .contentType(ContentType.JSON);

        api = new ApiClient(specification);
        beforeApiTestClass();
    }

    @AfterClass
    public final void afterApiClass() {
        afterApiTestClass();
    }

    protected void beforeApiTestClass() {}
    protected void afterApiTestClass() {}

    @BeforeMethod
    public final void beforeApiMethod() {
        beforeApiTestMethod();
    }

    @AfterMethod
    public final void afterApiMethod() {
        afterApiTestMethod();
    }

    protected void beforeApiTestMethod() {}
    protected void afterApiTestMethod() {}
}
