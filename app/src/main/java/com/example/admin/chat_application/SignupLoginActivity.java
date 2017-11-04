package com.example.admin.chat_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class SignupLoginActivity extends AppCompatActivity {

    String port_number = "5196";
    String ip_address = "192.168.0.106";


    public void connectToServer(String port_number, String  ip_address){
        String []strings = new String[2];
        strings[0] = ip_address;
        strings[1] = port_number;
        new ConnectToSocket().execute(strings);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_login);
        connectToServer(port_number, ip_address);
    }
}


