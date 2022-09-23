package dev.tttm.veterinerapp.api.entity;

import org.aspectj.bridge.IMessage;

public class Message {
    private String message;

    public Message(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
