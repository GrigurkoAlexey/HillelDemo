package ua.ithillel.lms.tests.web;

import org.testng.annotations.Test;
import ua.ithillel.infrastructure.utils.random.RandomString;
import ua.ithillel.lms.api.models.requests.SendCommentRequestModel;
import ua.ithillel.lms.api.models.response.UserDataResponseModel;
import ua.ithillel.lms.base.WebTestBase;
import ua.ithillel.lms.web.pages.FeedPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FeedTests extends WebTestBase {

    private String randomText;

    @Override
    protected void beforeWebTest() {
        randomText = RandomString.randomString(RandomString.Mode.ALPHANUMERIC, 20);
    }

    @Test
    public void testAddCommentToMessage() {
        String comment = web.getMainPage()
                .getFeedPage()
                .getFeedComponent()
                .getMessageByIndex(0)
                .addComment(randomText)
                .getCommentByValue(randomText);
        assertThat(comment).isEqualTo(randomText);
    }

    @Test
    public void testDeleteCommentToMessage() {
        String groupId = api.getUserProfileController().getUserData()
                .as(UserDataResponseModel.class).getResponse().getGroups().get(0);

        String messageId = api.getFeedController()
                .getMessagesFromFeed(groupId).body().jsonPath().get("response[0]._id");

        SendCommentRequestModel messageModel = new SendCommentRequestModel(messageId, randomText);
        api.getFeedController().sendCommentToMessage(messageModel);

        FeedPage feed = web.getMainPage().getFeedPage();

        feed.getFeedComponent()
                .getMessageByIndex(0)
                .deleteComment(randomText);

        feed.getConfirmModalComponent().confirm();

        assertThat(feed.getFeedComponent()
                .getMessageByIndex(0).getCommentByValue(randomText)).isEmpty();
    }
}
