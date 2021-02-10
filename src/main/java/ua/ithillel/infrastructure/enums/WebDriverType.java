package ua.ithillel.infrastructure.enums;

import com.google.common.base.Enums;

public enum WebDriverType {
    UNKNOWN, CHROME, FIREFOX;

    public static WebDriverType fromString(String value) {
        return Enums.getIfPresent(WebDriverType.class, value.toUpperCase()).or(UNKNOWN);
    }
}
