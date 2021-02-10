package ua.ithillel.lms.api.models.response;

import lombok.Data;

import java.util.List;

@Data
public class UserDataResponseModel {
    private Boolean success;
    private Response response;

    @Data
    public static class Response {
        private List<Avatar> avatars;
        private String birthday;
        private Boolean birthday_hide;
        private List<String> courses;
        private String email;
        private Boolean email_hide;
        private String first_name;
        private String first_name_en;
        private String first_name_ru;
        private String first_name_uk;
        private String gender;
        private Boolean gender_hide;
        private List<String> groups;
        private Integer groups_active;
        private Integer groups_archive;
        private String lang_certificate;
        private String last_name;
        private String last_name_en;
        private String last_name_ru;
        private String last_name_uk;
        private String lng;
        private List<Phone> phone;
        private Boolean phone_hide;
        private List<String> roles;
        private Integer telegram_id;
        private String _id;

        @Data
        private static class Avatar {
            private String destination;
            private String filename;
            private String _id;
        }

        @Data
        public static class Phone {
            private String country;
            private String dial_code;
            private String full_number;
            private String iso2;
            private String short_number;
        }
    }
}
