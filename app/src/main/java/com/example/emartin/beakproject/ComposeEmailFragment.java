package com.example.emartin.beakproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ComposeEmailFragment extends AppCompatActivity {

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

        mEmailAddress = (EditText) findViewById(R.id.from_edit);
        mSentEmailAddress = (EditText) findViewById(R.id.to_edit);
        mEmailSubject = (EditText) findViewById(R.id.subject_edit);
        mEmailBody = (EditText) findViewById(R.id.email_body);
        mSendEmail = (Button) findViewById(R.id.send_button);
        mAddProtection = (Button) findViewById(R.id.protect_button);
    }


    //load next class
    //dualmainscreen for enteremail
    //enableprotection for enableprotection
    public void loadActivity(View view) { //pass the view
        Intent intent = new Intent(this, DualScreenMainActivity.class);
        startActivity(intent);
    }


    public void addProtection(View view) {
        Intent intent = new Intent(this, EnableProtectionFragment.class);
        startActivity(intent);
    }


    //create onclick listener/innerclass for onbuttonpressed method
    public void composeMessage(View view) {

    }
    
}
