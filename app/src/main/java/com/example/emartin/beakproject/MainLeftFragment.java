package com.example.emartin.beakproject;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//List of Email Clients
public class MainLeftFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        Intent intent = getActivity().getIntent();

        return inflater.inflate(R.layout.main_left_fragment, container, false);
    }




}
