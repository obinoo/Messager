package com.example.Messager.Model;

import lombok.Data;

@Data
public class User {

    private MessageType type;
    private String content;
    private String senderName;
    private String receiverName;


    private enum MessageType{
        JOIN,
        CHAT,
        LEAVE
    }

}
