package com.example.admin.chat_application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Aniket on 04-Nov-2017.
 */

public class Client {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private static Client instance;
    private Client(){}
    public static Client getInstance(){
        if(instance == null){
            instance = new Client();
        }else{
            return instance;
        }
        return instance;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }
}
