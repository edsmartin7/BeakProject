package com.example.emartin.beakproject;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.Locale;

//Top Navigation Bar
//https://developer.android.com/training/appbar/index.html
//   ~https://developer.android.com/training/appbar/action-views.html
//https://design.google.com/icons/
//Navigation Drawer
//    https://material.google.com/patterns/navigation-drawer.html#
//    https://developer.android.com/training/implementing-navigation/nav-drawer.html
//    https://developer.android.com/training/design-navigation/index.html
//https://material.google.com/layout/principles.html#
//should have a back button for nav drawer
//~https://developer.android.com/training/implementing-navigation/temporal.html
//Fragments
//    ~https://developer.android.com/guide/components/fragments.html
//https://developer.android.com/training/basics/fragments/index.html
//https://developer.android.com/training/basics/fragments/creating.html
//http://www.tutorialspoint.com/android/android_fragments.htm
//https://www.raywenderlich.com/117838/introduction-to-android-fragments-tutorial
//https://medium.com/square-corner-blog/advocating-against-android-fragments-81fd0b462c97#.pfs52kjzd
//http://www.androiddesignpatterns.com/2013/04/retaining-objects-across-config-changes.html
//https://guides.codepath.com/android/Creating-and-Using-Fragments
//Email Clients
//
//Removed from manifest
//android:theme="@style/AppTheme"
//Git
//http://www.goprogramming.space/connecting-an-android-studio-project-with-github/
//Next
//create login screen android // email clients android // how to add email client android
//top navigation bar android // how to filter andorid //

public class MainActivity extends AppCompatActivity {

    private String[] mEmailClients;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    android.app.Fragment fragment = new FilteredClientFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Setting up Navigation Drawer
        mEmailClients = getResources().getStringArray(R.array.email_client_list);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mEmailClients)); //drawer_list_item.xml has empty TextView???

        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        //Set up the Navigation Drawer's Open/Close event
        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                myToolbar,
                R.string.drawer_open,
                R.string.drawer_close
                ) {
                //R.drawable.ic_drawer

        /*
        class CustomActionBarDrawerToggle extends ActionBarDrawerToggle{

                public CustomActionBarDrawerToggle(Activity mActivity,
                                                    DrawerLayout mDrawerLayout){
                    super(mActivity, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
                }
         */

            //Called when a drawer has settled in a completely closed state
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            //Called when a drawer has settled in a completely open state
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

    }

    // Action button command to open/close Navigation/Drawer
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    //Called whenever we call invalidateOptionsMenu()
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.main_drawer_layout).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Left Nav Drawer
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } //Will Never reach below code???

        //Right Settings Menu
        switch (item.getItemId()) {
            case R.id.action_options:
                return true;

            case R.id.action_compose_email:
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
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

    //Setting up response for Navigation Drawer (select filter email client)
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    //Swaps fragments in the main content view
    private void selectItem(int position) {
        // Create a new fragment and specify the planet to show based on position //FilteredClientFragment();
        //android.app.Fragment fragment = new FilteredClientFragment();
        Bundle args = new Bundle();
        args.putInt(FilteredClientFragment.EMAIL_CLIENT_LIST_NUMBER, position);
        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // same error
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mEmailClients[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }


    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }


    //Fragment that appears in the "content_frame", shows a planet
    public static class FilteredClientFragment extends android.app.Fragment {
        public static final String EMAIL_CLIENT_LIST_NUMBER = "planet_number";

        public FilteredClientFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_email_client, container, false);
            int i = getArguments().getInt(EMAIL_CLIENT_LIST_NUMBER);
            String planet = getResources().getStringArray(R.array.email_client_list)[i];

            int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
                    "drawable", getActivity().getPackageName());
            ((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);
            getActivity().setTitle(planet);
            return rootView;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
//Action Bar toggle issues
//http://stackoverflow.com/questions/26439619/how-to-replace-deprecated-android-support-v4-app-actionbardrawertoggle
//SetDrawerListener deprecated
//http://stackoverflow.com/questions/35639454/method-setdrawerlistener-is-deprecated
