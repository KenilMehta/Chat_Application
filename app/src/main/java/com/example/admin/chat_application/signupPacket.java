package com.example.admin.chat_application;

public class signupPacket extends Message {
    private static final long serialVersionUID = 1L;
    public String username;
    public String mob;
    public String pass;
    signupPacket(String sender,String receiver,
                 String username,String mob,String pass)
    {
        super(sender,receiver,0);
        this.username = username;
        this.mob = mob;
        this.pass = pass;
    }
}
