package ua.ithillel.lms.tests.web;

import org.testng.annotations.Test;
import ua.ithillel.lms.api.models.User;
import ua.ithillel.lms.base.WebTestBase;
import ua.ithillel.lms.web.models.UserProfile;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInTests extends WebTestBase {

    @Test
    public void testSignInWithValidCredentials() {
        User user = config.getUser();
        UserProfile expect = api.getUserProfileController().getUserProfile();
        web.clearCookies();
        web.getAuthPage()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .signIn();
        UserProfile profile = web.getMainPage().getProfileComponent().getUserProfile();
        assertThat(profile).isEqualTo(expect);
    }
}
