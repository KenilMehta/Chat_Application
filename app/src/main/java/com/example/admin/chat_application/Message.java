package com.example.admin.chat_application;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    String sender,receiver;
    int type;
    Message(String s,String r,int x)
    {
        sender=s;
        receiver = r;
        type = x;
    }
}


