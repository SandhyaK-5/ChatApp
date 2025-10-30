package com.example.chatapp.controller;

import com.example.chatapp.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage") // maps to /app/sendMessage
    @SendTo("/topic/messages")      // sends to all clients subscribed to /topic/messages
    public Message broadcastMessage(Message message) {
        return new Message(message.getFrom(), message.getText());
    }

    @MessageMapping("/typing")
@SendTo("/topic/typing")
public String userTyping(String username) {
    return username;
}

}
