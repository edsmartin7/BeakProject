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

//Activity Basics
    //~https://developer.android.com/reference/android/app/Activity.html
//https://developer.android.com/training/basics/firstapp/starting-activity.html
//https://developer.android.com/guide/components/fundamentals.html
//https://developer.android.com/guide/components/activities/tasks-and-back-stack.html
//https://developer.android.com/guide/components/activities/index.html
//https://developer.android.com/guide/components/activities/activity-lifecycle.html


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


public class ComposeEmailFragment extends AppCompatActivity{

    private EditText mEmailAddress;
    private EditText mSentEmailAddress;
    private EditText mEmailSubject;
    private EditText mEmailBody;
    private Button mSendEmail;
    private Button mAddProtection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compose_email_fragment);

        Intent intent = getIntent();

        }


    //load next class
    //dualmainscreen for enteremail
    //enableprotection for enableprotection
    public void loadActivity(View view){ //pass the view
        Intent intent = new Intent(this, DualScreenMainActivity.class);
        startActivity(intent);
    }

    //create onclick listener/innerclass for onbuttonpressed method
    public void composeMessage(View view){

        mEmailAddress = (EditText) findViewById(R.id.from_edit);
        mSentEmailAddress = (EditText) findViewById(R.id.to_edit);
        mEmailSubject = (EditText) findViewById(R.id.subject_edit);
        mEmailBody = (EditText) findViewById(R.id.email_body);
        mSendEmail = (Button) findViewById(R.id.send_button);
        mAddProtection = (Button) findViewById(R.id.protect_button);

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
                        loadActivity();
                    }
                }).start();
            }
        });

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