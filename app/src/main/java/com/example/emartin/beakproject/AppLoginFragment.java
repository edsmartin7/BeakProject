package com.example.emartin.beakproject;

//https://developer.android.com/guide/topics/ui/layout/linear.html

//import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

//not a fragment but a separate Activity?
//static
public class AppLoginFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.app_login_fragment, container, false);
    }

}

//link to web
//http://stackoverflow.com/questions/8992047/adding-a-web-link-to-a-textview-widget