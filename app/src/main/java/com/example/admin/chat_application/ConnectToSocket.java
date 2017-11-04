package com.example.admin.chat_application;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Aniket on 04-Nov-2017.
 */

public class ConnectToSocket extends AsyncTask<String, Void, Boolean>{
    private Client client;
    public ConnectToSocket() {
        super();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(aBoolean == true){

        }

    }

    @Override
    protected Boolean doInBackground(String... params) {
        try{
            Socket s;
            s = new Socket(params[0], Integer.parseInt(params[1]));
            client = Client.getInstance();
            client.setObjectInputStream((ObjectInputStream) s.getInputStream());
            client.setObjectOutputStream((ObjectOutputStream) s.getOutputStream());
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
