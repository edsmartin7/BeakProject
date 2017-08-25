package com.example.emartin.beakproject;

//Two fragments in Activity
//    ~http://stackoverflow.com/questions/17580593/android-two-fragments-in-same-activity
//    http://stackoverflow.com/questions/19722979/implementing-multiple-fragments-in-a-single-activity-dynamically
//    ~https://developer.android.com/training/basics/fragments/communicating.html
//    ~https://developer.android.com/training/basics/fragments/fragment-ui.html
//    ...http://www.vogella.com/tutorials/AndroidFragments/article.html
//    https://teamtreehouse.com/community/one-activity-two-fragments
//~https://developer.android.com/guide/components/fragments.html
//http://www.cs.dartmouth.edu/~campbell/cs65/lecture09/lecture09.html
//https://www.reddit.com/r/androiddev/comments/2wsb9w/single_activity_multiple_fragments_architecture/
//Menu items
//   https://developer.android.com/guide/topics/ui/menus.html
//Styles
//   https://www.tutorialspoint.com/android/android_styles_and_themes.htm
//   https://developer.android.com/guide/topics/ui/themes.html
//http://blog.danlew.net/2014/11/19/styles-on-android/
//http://www.vogella.com/tutorials/AndroidStylesThemes/article.html
//Android Networking
//https://developer.android.com/training/basics/network-ops/index.html
//Back Button
//https://developer.android.com/guide/components/fragments.html#Transactions
//https://developer.android.com/reference/android/app/Fragment.html
//https://developer.android.com/training/basics/fragments/creating.html
//https://developer.android.com/training/implementing-navigation/temporal.html
//else (destroy all views)
//http://stackoverflow.com/questions/18309815/fragments-displayed-over-each-other
//recyclverView
//https://developer.android.com/training/material/lists-cards.html
//https://developer.android.com/guide/topics/ui/layout/recyclerview.html
//https://stackoverflow.com/documentation/android/169/recyclerview#t=201708250439137251251

//WYSIWYG editor


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


//extends FragmentActivity?
public class DualScreenMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dual_screen_main_activity);

        //Toolbar (Menu: compose email)
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        createLeftFragment();
        createRightFragment();

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
                createComposeEmailFragment();
                return true;
            case R.id.action_add_client:
                createEmailAuthorizationFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Create Compose Email Fragment
    public void createComposeEmailFragment(){ //View view){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ComposeEmailFragment fragment = new ComposeEmailFragment();
        //fragmentTransaction.add(R.id.dual_screen_main, fragment);
        fragmentTransaction.replace(R.id.dual_screen_main, fragment);
        //fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.commit();

    }

    public void createEmailAuthorizationFragment(){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        EmailAuthorizationFragment fragment = new EmailAuthorizationFragment();
        fragmentTransaction.replace(R.id.dual_screen_main, fragment);
        //fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.commit();

    }

    //scrolling list of email clients
    public void createLeftFragment(){

        //Left Fragment
        FragmentManager leftSideManager = getFragmentManager();
        FragmentTransaction leftFragmentTransaction = leftSideManager.beginTransaction();

        MainLeftFragment left_fragment = new MainLeftFragment();
        leftFragmentTransaction.replace(R.id.list_of_email_clients, left_fragment);
        leftFragmentTransaction.commit();

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

//declare all(?) activities in Manifest.xml
//http://stackoverflow.com/questions/8107789/android-error-unable-to-find-explicit-activity-class
//to change starting activity
//http://stackoverflow.com/questions/3631982/change-applications-starting-activity
//disable landscape orientation
//http://stackoverflow.com/questions/18189705/how-to-disable-rotating-to-landscape-mode
//styles
//http://stackoverflow.com/questions/25203501/android-creating-a-circular-textview
//-color hexadecimals
//http://www.color-hex.com/color/98afc7
//rounded corners again
//http://tips.androidhive.info/2013/09/android-layout-rounded-corner-border/
