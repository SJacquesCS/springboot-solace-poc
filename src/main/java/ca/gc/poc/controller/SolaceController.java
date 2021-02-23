package ca.gc.poc.controller;

import ca.gc.poc.dto.SolaceMessage;
import ca.gc.poc.service.SolaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolaceController {

    @Autowired
    private SolaceService solaceService;

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody SolaceMessage solaceMessage) {
        return new ResponseEntity<>(solaceService.sendMessage(solaceMessage), HttpStatus.ACCEPTED);
    }
}
