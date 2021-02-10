package ua.ithillel.lms.api.models.response;

import lombok.Data;

import java.util.List;

@Data
public class FeedResponseModel {
    private Boolean success;
    private List<Message> response;

    @Data
    public static class Message {
        private String _id;
        private String text;
        private List<String> images;
        private List<String> files;
        private List<Author> likes;
        private List<Comment> comments;
        private Author author;
        private String createdAt;
        private String type;

        @Data
        public static class Comment {
            private String _id;
            private String message;
            private Author author;
        }

        @Data
        public static class Author {
            private String _id;
            private List<Avatar> avatars;
            private String first_name;
            private String last_name;
            private String first_name_en;
            private String last_name_en;
            private String first_name_ru;
            private String last_name_ru;
            private String first_name_uk;
            private String last_name_uk;
        }

        @Data
        public static class Avatar {
            private String _id;
            private String destination;
            private String filename;
        }
    }
}
