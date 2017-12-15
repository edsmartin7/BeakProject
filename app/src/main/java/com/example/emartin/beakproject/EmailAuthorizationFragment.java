package com.example.emartin.beakproject;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EmailAuthorizationFragment extends AppCompatActivity{

    private EditText mEmailAddress;
    private EditText mPassword;
    private Button mConnectEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_existing_email_fragment);

        Intent intent = getIntent();

        mConnectEmail = (Button) findViewById(R.id.enter_connect_client);
        mEmailAddress = (EditText) findViewById(R.id.add_email_address);
        mPassword = (EditText) findViewById(R.id.confirm_password);

        //start save email data method
        mConnectEmail.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //start new thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        saveEmailAddress();
                    }
                }).start();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        getSupportActionBar().show();
    }

    public void saveEmailAddress(){

    }

}
