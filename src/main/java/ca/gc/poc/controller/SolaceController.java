package ca.gc.poc.controller;

import ca.gc.poc.dto.SolaceMessage;
import ca.gc.poc.service.SolaceService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class SolaceController {

    @Autowired
    private SolaceService solaceService;

    @PostMapping("/send-message")
    @ApiResponses(value = {@ApiResponse(code = 202, message = "Message sent successfully. :)")})
    public ResponseEntity<String> sendMessage(@RequestBody SolaceMessage solaceMessage) {
        return new ResponseEntity<>(solaceService.sendMessage(solaceMessage), HttpStatus.ACCEPTED);
    }

    @PostMapping("/send-message-queue")
    @ApiResponses(value = {@ApiResponse(code = 202, message = "Message sent successfully. :)")})
    public ResponseEntity<String> sendMessageQueue(@RequestBody SolaceMessage solaceMessage) {
        return new ResponseEntity<>(solaceService.sendMessageQueue(solaceMessage), HttpStatus.ACCEPTED);
    }
}
