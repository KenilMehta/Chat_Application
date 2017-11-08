package com.example.admin.chat_application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aniket on 04-Nov-2017.
 */

public class SignUpFragment extends Fragment {
    EditText username,mob,pass,cpass;
    Client c;
    TextView displayMessage;
    Button submit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.signup,container,false);
        username = (EditText) v.findViewById(R.id.signup_username);
        mob = (EditText) v.findViewById(R.id.signup_mob);
        pass = (EditText) v.findViewById(R.id.signup_pass);
        cpass = (EditText) v.findViewById(R.id.signup_confirm);
        displayMessage = (TextView) v.findViewById(R.id.signup_show_message);
        submit = (Button) v.findViewById(R.id.submit_button);
        c = Client.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sender = username.getText().toString();
                String receiver = "";
                String mobile = mob.getText().toString();
                String password = pass.getText().toString();
                signupPacket packet = new signupPacket(sender,receiver,sender,mobile,password);
                c.send(packet);
                if(c.receiveAck()==1)
                {
                    Toast.makeText(getActivity(),"Success",Toast.LENGTH_SHORT);
                }else{
                    Toast.makeText(getActivity(),"UnSuccess",Toast.LENGTH_SHORT);
                }
            }
        });

        return v;
    }
}
