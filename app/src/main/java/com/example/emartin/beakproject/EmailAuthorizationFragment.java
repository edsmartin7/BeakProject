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

public class EmailAuthorizationFragment extends Fragment{

    private EditText mEmailAddress;
    private EditText mPassword;
    private Button mConnectEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        Intent intent = getActivity().getIntent();

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return inflater.inflate(R.layout.enter_existing_email_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mConnectEmail = (Button) getActivity().findViewById(R.id.enter_connect_client);
        mEmailAddress = (EditText) getActivity().findViewById(R.id.add_email_address);
        mPassword = (EditText) getActivity().findViewById(R.id.confirm_password);

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

    public void saveEmailAddress(){

    }

}
