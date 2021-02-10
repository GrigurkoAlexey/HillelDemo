package ua.ithillel.lms.api.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SendMessageRequestModel {
    private List<String> files;
    private String group;
    private String text;
}
