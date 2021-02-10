package ua.ithillel.lms.tests.api;

import org.testng.annotations.Test;
import ua.ithillel.infrastructure.config.ConfigurationManager;
import ua.ithillel.lms.api.controllers.AuthorizeController;

import static org.hamcrest.Matchers.*;

public class AuthorizationTests {

    private AuthorizeController authController = new AuthorizeController();

    @Test
    public void testAuthorizeWithValidCredentials() {
        authController.authorize(ConfigurationManager.getInstance().getUser()).then()
                .assertThat().statusCode(200)
                .body("success", equalTo(true))
                .body("response._id", matchesPattern("[a-z0-9]+"));
    }
}
