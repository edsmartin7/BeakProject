package com.example.emartin.beakproject;

//https://developer.android.com/guide/topics/ui/layout/linear.html
//    http://www.tutorialspoint.com/android/android_login_screen.htm
//    ~http://sourcey.com/beautiful-android-login-and-signup-screens-with-material-design/
//~https://developer.android.com/studio/projects/templates.html



import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//not a fragment but a separate Activity?
//static
//Needs to extend activity to resolve errors
public class AppLoginFragment extends AppCompatActivity{

    Button b1;
    EditText username,password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_login_fragment);

        b1=(Button)findViewById(R.id.button);
        username = (EditText)findViewById(R.id.enter_username);
        password = (EditText)findViewById(R.id.enter_password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    /*
    //removed because not extending fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.app_login_fragment, container, false);

    }
    */

    /*
    //onclick method
    public void login(View view){
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){

            //correcct password
        }else{
            //wrong password
        }
     */

    }

//link to web
//http://stackoverflow.com/questions/8992047/adding-a-web-link-to-a-textview-widget
//git: clone a specific branch
//http://stackoverflow.com/questions/1911109/how-to-clone-a-specific-git-branch/4568323#456832