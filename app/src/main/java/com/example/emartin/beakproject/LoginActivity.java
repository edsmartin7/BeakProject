package com.example.emartin.beakproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    Button enter_button;
    EditText username, password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_login_fragment);

        username = (EditText) findViewById(R.id.enter_username);
        password = (EditText) findViewById(R.id.enter_password);
        enter_button = (Button) findViewById(R.id.enter_button);

    }

    public void login(View view) {
        if (username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DualScreenMainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
        }
    }

}
