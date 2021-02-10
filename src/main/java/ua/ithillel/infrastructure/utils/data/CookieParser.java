package ua.ithillel.infrastructure.utils.data;

import org.openqa.selenium.Cookie;

public class CookieParser {

    public static Cookie parseFromString(String cookie) {
        String[] parts = cookie.split(";");
        return new Cookie.Builder(parts[0].split("=")[0], parts[0].split("=")[1])
                .domain("lms.ithillel.ua")
                .path("/")
                .isHttpOnly(true)
                .isSecure(false)
                .expiresOn(null)
                .build();
    }
}
