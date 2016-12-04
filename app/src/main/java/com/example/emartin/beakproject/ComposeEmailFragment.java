package com.example.emartin.beakproject;

//styles
//   https://developer.android.com/guide/topics/ui/themes.html
//   https://developer.android.com/guide/topics/resources/style-resource.html
//   http://stackoverflow.com/questions/5778187/change-the-look-of-edit-text-box-in-android
//Adapters
//   https://developer.android.com/guide/topics/ui/declaring-layout.html#AdapterViews
//Native Android email client (deprecated?)
//   https://www.tutorialspoint.com/android/android_sending_email.htm
//

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ComposeEmailFragment extends Fragment{

    private EditText mEmailAddress;
    private EditText mSentEmailAddress;
    private EditText mEmailSubject;
    private EditText mEmailBody;
    private Button mSendEmail;
    private Button mAddProtection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        Intent intent = getActivity().getIntent();

        return inflater.inflate(R.layout.compose_email_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //create onclick listener/innerclass for onbuttonpressed method
        //add prefix getActivity().findViewById to make that work

        mEmailAddress = (EditText) getActivity().findViewById(R.id.from_edit);
        mSentEmailAddress = (EditText) getActivity().findViewById(R.id.to_edit);
        mEmailSubject = (EditText) getActivity().findViewById(R.id.subject_edit);
        mEmailBody = (EditText) getActivity().findViewById(R.id.email_body);
        mSendEmail = (Button) getActivity().findViewById(R.id.send_button);
        mAddProtection = (Button) getActivity().findViewById(R.id.protect_button);

        //add on click attribute to other activity's xml

        mSendEmail.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //start new thread
            }
        });


        //start create enable protection email fragment
        mAddProtection.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //start new thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        createEnableProtectionFragment();
                    }
                }).start();
            }
        });

    }

    //create Enable Protection Email fragment
    public void createEnableProtectionFragment(){

        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        EnableProtectionFragment fragment = new EnableProtectionFragment();
        fragmentTransaction.replace(R.id.compose_email_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

}

//multiline text box for email content
//http://stackoverflow.com/questions/4233626/allow-multi-line-in-edittext-view-in-android
//gmail API
//https://developers.google.com/gmail/api/quickstart/android
//https://developers.google.com/gmail/api/guides/
//outlook API
//https://dev.outlook.com/
//hide actionbar(toolbar) in fragments
//http://stackoverflow.com/questions/21504088/how-to-hide-action-bar-for-fragment
//~http://stackoverflow.com/a/38196319