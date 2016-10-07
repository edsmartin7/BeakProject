package com.example.emartin.beakproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

//Top Navigation Bar
//https://developer.android.com/training/appbar/index.html
//~https://developer.android.com/training/appbar/action-views.html
//https://design.google.com/icons/
//Navigation Drawer
//    https://material.google.com/patterns/navigation-drawer.html#
//https://developer.android.com/training/implementing-navigation/nav-drawer.html
//https://developer.android.com/training/design-navigation/index.html
//Fragments
//
//Email Clients
//
//Removed from manifest
//android:theme="@style/AppTheme"
//Git
//http://www.goprogramming.space/connecting-an-android-studio-project-with-github/
//Next
//create login screen android // email clients android // how to add email client android
//top navigation bar android //

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_options:
                return true;

            case R.id.action_compose_email:
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    
}
