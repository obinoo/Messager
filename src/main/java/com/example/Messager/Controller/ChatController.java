package com.example.Messager.Controller;

import com.example.Messager.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public User receivePublicMessage(@Payload User user){

        return user;
    }

   @MessageMapping("/private-message")
    public User receivePrivateMessage(User user){

        template.convertAndSendToUser(user.getReceiverName(), "private", user);

        return user;
    }
}
