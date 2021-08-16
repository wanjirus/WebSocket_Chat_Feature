package com.stanm.chatfeature_spring_socket.Controller;

import com.stanm.chatfeature_spring_socket.Model.ChatMessages;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat.registerUser")
    @SendTo("/chat/public")

    public ChatMessages registerUser(@Payload ChatMessages chatMessages, SimpMessageHeaderAccessor headerAccessor){
    headerAccessor.getSessionAttributes().put("username",chatMessages.getSender());
        return  chatMessages;
    }
    @MessageMapping("/chat.send")
    @SendTo("/chat/public")

public ChatMessages sendMessage(@Payload ChatMessages chatMessages){
     return chatMessages;
}
}
