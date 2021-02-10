package ua.ithillel.lms.api.controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ua.ithillel.infrastructure.utils.data.Date;
import ua.ithillel.lms.api.models.response.UserDataResponseModel;
import ua.ithillel.lms.web.models.UserProfile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class UserProfileController {

    private RequestSpecification specification;

    public UserProfileController(RequestSpecification specification) {
        this.specification = specification;
    }

    public UserProfile getUserProfile() {
        UserProfile userProfile = new UserProfile();
        UserDataResponseModel data = getUserData().as(UserDataResponseModel.class);
        userProfile.setFirstName(data.getResponse().getFirst_name());
        userProfile.setLastName(data.getResponse().getLast_name());
        userProfile.setEmail(data.getResponse().getEmail());
        userProfile.setPhone(data.getResponse().getPhone().get(0).getFull_number());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat.parse(data.getResponse().getBirthday()));
            int age = Date.calculateAge(
                    LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DATE)), LocalDate.now());
            userProfile.setAge(age + " years");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return userProfile;
    }

    public Response getUserData() {
        Response response = RestAssured.given(specification)
                .log().uri().log().method()
                .basePath("/api/lms/users/mydata")
                .get();
        response.then().log().body();
        return response;
    }
}
