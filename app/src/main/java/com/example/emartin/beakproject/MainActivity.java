package com.example.emartin.beakproject;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.drawer_open,
                R.string.drawer_close
                );
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_viewer);
        navigationView.setNavigationItemSelectedListener(this);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        //getActionBar().setHomeButtonEnabled(true);
    }

    //select items from navigation drawers
    //filter by email clients selected and track/not tracked
    private void filterItem(int position) {

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

        if(mDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }
        return super.onOptionsItemSelected(item);
        /*
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
        */
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.test1:
                Toast.makeText(this, "TESTING ONE", Toast.LENGTH_SHORT).show();
            case R.id.test2:
                Toast.makeText(this, "TESTING TWO", Toast.LENGTH_SHORT).show();
            case R.id.test3:
                Toast.makeText(this, "TESTING THREE", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void createComposeEmailActivity() {}
    public void createEmailAuthorizationActivity() {}

}
