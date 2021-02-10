package ua.ithillel.lms.api.models.response;

import lombok.Data;

import java.util.List;

@Data
public class SendCommentToMsgResponse {
    private Boolean success;
    private List<Response> response;

    @Data
    public static class Response {
        private String _id;
        private String message;
        private Author author;
        private String id;

        @Data
        public static class Author {
            private List<Avatar> avatars;
            private String _id;
            private String first_name;
            private String last_name;
            private String first_name_en;
            private String last_name_en;
            private String first_name_ru;
            private String last_name_ru;
            private String first_name_uk;
            private String last_name_uk;
            private String id;

            @Data
            public static class Avatar {
                private String _id;
                private String destination;
                private String filename;
            }
        }
    }
}
