package ua.ithillel.lms.api;

import io.restassured.specification.RequestSpecification;
import ua.ithillel.lms.api.controllers.FeedController;
import ua.ithillel.lms.api.controllers.UserProfileController;

public class ApiClient {

    private RequestSpecification specification;

    public ApiClient(RequestSpecification specification) {
        this.specification = specification;
    }

    public FeedController getFeedController() {
        return new FeedController(specification);
    }

    public UserProfileController getUserProfileController() {
        return new UserProfileController(specification);
    }
}
