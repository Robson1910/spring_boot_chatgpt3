package io.github.robson.spring_boot_chatgpt3.controller;

import io.github.robson.spring_boot_chatgpt3.service.ChatGptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGptController {

    private final ChatGptService chatGptService;
    private String lastResponse;

    public ChatGptController(ChatGptService chatGptService){
        this.chatGptService = chatGptService;
    }

    @PostMapping("/request")
    public void request(@RequestBody String question){
        lastResponse = chatGptService.getResponse(question);
    }

    @GetMapping("/response")
    public String getResponse(){
        return lastResponse;
    }
}