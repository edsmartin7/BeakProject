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
/*
To perform a transaction such as add or remove a fragment,
you must use the FragmentManager to create a FragmentTransaction,
which provides APIs to add, remove, replace, and perform other fragment transactions.
*/

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

        //Left Fragment

        //RightFragment
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
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

}
//declare all(?) activities in Manifest.xml
//http://stackoverflow.com/questions/8107789/android-error-unable-to-find-explicit-activity-class
//to change starting activity
//http://stackoverflow.com/questions/3631982/change-applications-starting-activity
//disable landscape orientation
//http://stackoverflow.com/questions/18189705/how-to-disable-rotating-to-landscape-mode
