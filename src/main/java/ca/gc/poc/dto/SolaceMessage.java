package ca.gc.poc.dto;

import lombok.Data;

@Data
public class SolaceMessage {
    private String message;
    private String topic;
    private String username;
    private String password;


}
