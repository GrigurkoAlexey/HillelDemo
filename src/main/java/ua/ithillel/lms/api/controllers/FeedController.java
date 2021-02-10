package ua.ithillel.lms.api.controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ua.ithillel.lms.api.models.requests.SendCommentRequestModel;
import ua.ithillel.lms.api.models.requests.SendMessageRequestModel;

public class FeedController {

    private RequestSpecification specification;

    public FeedController(RequestSpecification specification) {
        this.specification = specification;
    }

    public Response sendMessage(SendMessageRequestModel model) {
        Response response = RestAssured.given(specification)
                .log().all()
                .basePath("/api/lms/posts")
                .body(model)
                .when().post();
        response.then().log().all();
        return response;
    }

    public Response sendCommentToMessage(SendCommentRequestModel model) {
        Response response = RestAssured.given(specification)
                .basePath("/api/lms/comments")
                .body(model)
                .when().post();
        response.then().log().status().log().body();
        return response;
    }

    public Response deleteCommentFromMessage(String commentId) {
        Response response = RestAssured.given(specification)
                .basePath("/api/lms/comments/" + commentId)
                .when().delete();
        response.then().log().status().log().body();
        return response;
    }

    public Response getMessagesFromFeed(String groupId) {
        Response response = RestAssured.given(specification)
                .basePath("/api/lms/posts/group/" + groupId)
                .when().get();
        response.then().log().status().log().body();
        return response;
    }
}
