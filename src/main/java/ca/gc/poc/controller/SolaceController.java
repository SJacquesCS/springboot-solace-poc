package ca.gc.poc.controller;

import ca.gc.poc.dto.SolaceMessage;
import ca.gc.poc.service.SolaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SolaceController {

    @Autowired
    private SolaceService solaceService;

    @PostMapping("/send-message")
    public String sendMessage(@RequestBody SolaceMessage solaceMessage) {
        return solaceService.sendMessage(solaceMessage);
    }
}
