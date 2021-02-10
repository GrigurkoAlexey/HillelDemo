package ua.ithillel.lms.api.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendCommentRequestModel {
    private String entry;
    private String message;
}
