package ua.ithillel.lms.tests.api;

import org.testng.annotations.Test;
import ua.ithillel.lms.api.models.requests.SendMessageRequestModel;
import ua.ithillel.lms.base.ApiTestBase;

import java.util.ArrayList;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class SendMessageTests extends ApiTestBase {

    @Test
    public void testSendMessage() {
        SendMessageRequestModel model = new SendMessageRequestModel(new ArrayList<>(), "5ca9c23cf380b947f10e31ef", "Hello");
        api.getFeedController().sendMessage(model)
                .then().assertThat()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("response.text", equalTo("Hello"))
                .body(matchesJsonSchemaInClasspath("schemas/sendMessageSchema.json"));
    }

    @Test(dependsOnMethods = "testSendMessage")
    public void testDeleteMessage() {}
}
