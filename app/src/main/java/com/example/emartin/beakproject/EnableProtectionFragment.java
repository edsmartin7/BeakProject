package com.example.emartin.beakproject;

//textbox
//add style to android manifest application
//http://stackoverflow.com/questions/33138862/text-box-in-android

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class EnableProtectionFragment extends AppCompatActivity{

    private CheckBox enableProtection;
    private EditText numberOfViews;
    private CheckBox enableUnlimitedViews;
    private Button enterProtection;
    private Button cancelProtection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enable_protection_fragment);

        Intent intent = getIntent();
        getSupportActionBar().hide();

    }

}
