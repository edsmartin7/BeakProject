package com.example.emartin.beakproject;

//Two fragments in Activity
//    ~http://stackoverflow.com/questions/17580593/android-two-fragments-in-same-activity
//    http://stackoverflow.com/questions/19722979/implementing-multiple-fragments-in-a-single-activity-dynamically
//    ~https://developer.android.com/training/basics/fragments/communicating.html
//    ~https://developer.android.com/training/basics/fragments/fragment-ui.html
//    ...http://www.vogella.com/tutorials/AndroidFragments/article.html
//    https://teamtreehouse.com/community/one-activity-two-fragments
//~https://developer.android.com/guide/components/fragments.html
//    http://www.survivingwithandroid.com/2013/04/android-fragment-transaction.html
//Menu items
//   https://developer.android.com/guide/topics/ui/menus.html
//Styles
//   https://www.tutorialspoint.com/android/android_styles_and_themes.htm
//   https://developer.android.com/guide/topics/ui/themes.html
//   http://blog.danlew.net/2014/11/19/styles-on-android/
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

        if(findViewById(R.id.main_screen_container) != null){

            if (savedInstanceState != null){
                return;
            }

            //Left Fragment
            FragmentManager leftSideManager = getFragmentManager();
            FragmentTransaction leftFragmentTransaction = leftSideManager.beginTransaction();

            MainLeftFragment left_fragment = new MainLeftFragment();
            leftFragmentTransaction.replace(R.id.list_of_email_clients, left_fragment);
            leftFragmentTransaction.addToBackStack(null);
            //leftFragmentTransaction.add(R.id.list_of_email_clients, left_fragment);
            leftFragmentTransaction.commit();

            /*
            left_fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.list_of_email_clients, left_fragment)
                    .commit();
             */


            //RightFragment
            FragmentManager rightSideManager = getFragmentManager();
            FragmentTransaction rightFragmentTransaction = rightSideManager.beginTransaction();

            MainRightFragment right_fragment = new MainRightFragment();
            rightFragmentTransaction.replace(R.id.list_of_tracked_emails, right_fragment);
            rightFragmentTransaction.addToBackStack(null);
            //rightFragmentTransaction.add(R.id.list_of_tracked_emails, right_fragment);
            rightFragmentTransaction.commit();

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

        Intent intent = new Intent(this, ComposeEmailFragment.class);
        startActivity(intent);

    }

    public void createEmailAuthorizationFragment(){

        Intent intent = new Intent(this, EmailAuthorizationFragment.class);
        startActivity(intent);

    }

    //scrolling list of email clients
    public void createLeftFragment(){}

    //scrolling list of emails
    public void createRightFragment(){}


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
