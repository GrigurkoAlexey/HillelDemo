package ua.ithillel.infrastructure.enums;

import com.google.common.base.Enums;

public enum RunOn {
    UNKNOWN, LOCAL, REMOTE;

    public static RunOn fromString(String value) {
        return Enums.getIfPresent(RunOn.class, value.toUpperCase()).or(UNKNOWN);
    }
}
