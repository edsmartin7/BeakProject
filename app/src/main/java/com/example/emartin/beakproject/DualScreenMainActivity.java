package com.example.emartin.beakproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//main screen emails
//navigation drawer: filters by client, settings, add new email clients, etc
//toolbar menu: compose email
public class DualScreenMainActivity extends AppCompatActivity {

    //left side email client list
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dual_screen_main_activity);

        //Toolbar (Menu: compose email)
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //createLeftFragment();
        //createRightFragment();

    }

    //Add Menu (right) to ToolBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_top_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_options);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);

        // Configure the search info and add any event listeners...

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_compose_email:
                createComposeEmailActivity();
                return true;
            case R.id.action_add_client:
                createEmailAuthorizationActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Create Compose Email Activity
    public void createComposeEmailActivity() {
        Intent intent = new Intent(this, ComposeEmailFragment.class);
        startActivity(intent);
    }

    public void createEmailAuthorizationActivity(){
        Intent intent = new Intent(this, EmailAuthorizationFragment.class);
        startActivity(intent);
    }

    //scrolling list of email clients
    public void createLeftFragment(){
        //Left Fragment
        FragmentManager leftSideManager = getFragmentManager();
        FragmentTransaction leftFragmentTransaction = leftSideManager.beginTransaction();

        MainLeftFragment left_fragment = new MainLeftFragment();
        leftFragmentTransaction.replace(R.id.list_of_email_clients, left_fragment);
        leftFragmentTransaction.commit();

        //content of left side (email client list)
        mRecyclerView = (RecyclerView) findViewById(R.id.email_client_list);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        //mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    //scrolling list of emails
    public void createRightFragment(){
        //RightFragment
        FragmentManager rightSideManager = getFragmentManager();
        FragmentTransaction rightFragmentTransaction = rightSideManager.beginTransaction();

        MainRightFragment right_fragment = new MainRightFragment();
        rightFragmentTransaction.replace(R.id.list_of_tracked_emails, right_fragment);
        rightFragmentTransaction.commit();
    }

}
