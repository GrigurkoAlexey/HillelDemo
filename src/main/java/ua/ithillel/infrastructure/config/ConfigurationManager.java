package ua.ithillel.infrastructure.config;

import ua.ithillel.infrastructure.enums.RunOn;
import ua.ithillel.infrastructure.enums.WebDriverType;
import ua.ithillel.lms.api.models.User;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private String baseUrl;
    private RunOn runOn;
    private WebDriverType type;
    private User user;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (instance == null)
            instance = new ConfigurationManager();
        return instance;
    }

    public String getBaseUrl() {
        if (baseUrl == null)
            baseUrl = getEnvVariableOrDefault("baseUrl", "https://lms.ithillel.ua/");
        return baseUrl;
    }

    public RunOn getRunOn() {
        if (runOn == null)
            runOn = RunOn.fromString(getEnvVariableOrDefault("runOn", "local"));
        return runOn;
    }

    public WebDriverType getWebDriverType() {
        if (type == null)
            type = WebDriverType.fromString(getEnvVariableOrDefault("webDriverType", "chrome"));
        return type;
    }

    public User getUser() {
        if (user == null) {
            String email = getEnvVariableOrDefault("email", "alexgrigurko94@gmail.com");
            String password = getEnvVariableOrDefault("password", "Qwerty!12345");
            user = new User(email, password);
        }
        return user;
    }

    private String getEnvVariableOrDefault(String env, String def) {
        String environmentVariable = System.getenv(env);
        return environmentVariable == null || environmentVariable.isBlank() ? def : environmentVariable;
    }
}
