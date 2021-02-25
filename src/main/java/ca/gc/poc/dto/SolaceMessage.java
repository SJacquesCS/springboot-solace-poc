package ca.gc.poc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SolaceMessage {

    @Schema(example = "Test-message", description = "This is the message you want to send.")
    private String message;
    private String topic;
    private String username;
    private String password;
    private String queueName;


}
