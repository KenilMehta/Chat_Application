package com.example.admin.chat_application;

import android.util.Log;

import java.io.IOException;
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

    void send(Message m)
    {
        try {
            objectOutputStream.writeObject(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    int receiveAck()
    {
        int res=0;
        try {
            res= (int) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    Message receiveMsg()
    {
        Message m=null;
        try {
            m = (Message) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return m;
    }
    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
        Log.d("Client", "ObjIn for Client is successfull");
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }
}

