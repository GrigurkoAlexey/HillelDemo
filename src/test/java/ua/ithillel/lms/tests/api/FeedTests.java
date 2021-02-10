package ua.ithillel.lms.tests.api;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import ua.ithillel.infrastructure.utils.random.RandomString;
import ua.ithillel.lms.api.models.requests.SendCommentRequestModel;
import ua.ithillel.lms.api.models.response.FeedResponseModel;
import ua.ithillel.lms.api.models.response.SendCommentToMsgResponse;
import ua.ithillel.lms.api.models.response.UserDataResponseModel;
import ua.ithillel.lms.base.ApiTestBase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FeedTests extends ApiTestBase {

    private String comment = RandomString.randomString(RandomString.Mode.ALPHA, 10);

    private String groupId;
    private String messageId;
    private String commentId;
    private int countOfComments;

    @Override
    protected void beforeApiTestClass() {
        logger.log("Get User group id");
        groupId = api.getUserProfileController().getUserData()
                .as(UserDataResponseModel.class).getResponse().getGroups().get(0);

        logger.log("Get first message id");
        messageId = api.getFeedController()
                .getMessagesFromFeed(groupId).body().jsonPath().get("response[0]._id");
    }

    @Test
    public void testCommentToMessage() {
        logger.log("Send comment " + comment + " to message " + messageId);
        SendCommentRequestModel messageModel = new SendCommentRequestModel(messageId, comment);
        SendCommentToMsgResponse commentToMsgRes = api.getFeedController()
                .sendCommentToMessage(messageModel).as(SendCommentToMsgResponse.class);

        logger.log("Check response status success");
        assertThat(commentToMsgRes.getSuccess()).isTrue();

        logger.log("Check response comment is " + comment);
        countOfComments = commentToMsgRes.getResponse().size();
        commentId = commentToMsgRes.getResponse().get(countOfComments - 1).get_id();
        assertThat(commentToMsgRes.getResponse().get(countOfComments - 1).getMessage()).isEqualTo(comment);

        logger.log("Get message with all comments");
        FeedResponseModel messages = api.getFeedController().getMessagesFromFeed(groupId).as(FeedResponseModel.class);

        logger.log("Check that comment is present in message");
        assertThat(messages.getResponse().get(0).getComments()).isNotEmpty();
        assertThat(messages.getResponse().get(0).getComments().get(countOfComments - 1).getMessage())
                .isEqualTo(comment);
    }

    @Test(dependsOnMethods = "testCommentToMessage")
    public void testDeleteMessageFromFeed() {
        logger.log("Delete comment " + comment + " from message " + messageId);
        api.getFeedController().deleteCommentFromMessage(commentId)
                .then().assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
        FeedResponseModel messages = api.getFeedController().getMessagesFromFeed(groupId).as(FeedResponseModel.class);
        assertThat(messages.getResponse().get(0).getComments().size()).isEqualTo(countOfComments - 1);
    }
}
