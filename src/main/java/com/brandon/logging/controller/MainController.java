package com.brandon.logging.controller;

import com.brandon.logging.pojo.Message;
import com.brandon.logging.pojo.MsgRequest;
import com.brandon.logging.service.MessageService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class MainController {

    private final MessageService messageService;

    public MainController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(path = "/api/dummy", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<JsonNode> dummyRequest(@RequestHeader Map<String, String> headers) {
        log.info("(start=starter, recipientList=[123456789, 098765432], value=something)");
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/api/functional", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Message> functionInterface(@RequestBody MsgRequest message) {
        log.info("Received the following message: {}", message);

        return ResponseEntity.ok(messageService.processMessage(message));
    }
}
