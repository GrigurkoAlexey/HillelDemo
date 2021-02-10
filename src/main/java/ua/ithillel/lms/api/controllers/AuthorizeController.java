package ua.ithillel.lms.api.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ua.ithillel.lms.api.models.User;

public class AuthorizeController {

    public Response authorize(User user) {
        Response response = RestAssured.given()
                .log().all()
                .baseUri("https://lms.ithillel.ua")
                .basePath("/api/lms/users/login")
                .contentType(ContentType.JSON)
                .body(user)
                .when().post();
        response.then().log().body().log().headers();
        return response;
    }
}
