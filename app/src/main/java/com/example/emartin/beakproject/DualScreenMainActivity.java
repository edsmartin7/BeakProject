package com.example.emartin.beakproject;

//Two fragments in Activity
//    ~http://stackoverflow.com/questions/17580593/android-two-fragments-in-same-activity
//    http://stackoverflow.com/questions/19722979/implementing-multiple-fragments-in-a-single-activity-dynamically
//    ~https://developer.android.com/training/basics/fragments/communicating.html
//    ~https://developer.android.com/training/basics/fragments/fragment-ui.html
//    ...http://www.vogella.com/tutorials/AndroidFragments/article.html
//    https://teamtreehouse.com/community/one-activity-two-fragments
//https://developer.android.com/guide/components/fragments.html
//http://www.cs.dartmouth.edu/~campbell/cs65/lecture09/lecture09.html
//https://www.reddit.com/r/androiddev/comments/2wsb9w/single_activity_multiple_fragments_architecture/

/*
To perform a transaction such as add or remove a fragment,
you must use the FragmentManager to create a FragmentTransaction,
which provides APIs to add, remove, replace, and perform other fragment transactions.
*/

//WYSIWYG editor


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
//import android.app.Fragment;

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

    //Create Compose Email Fragment

}
//declare all(?) activities in Manifest.xml
//http://stackoverflow.com/questions/8107789/android-error-unable-to-find-explicit-activity-class
//to change starting activity
//http://stackoverflow.com/questions/3631982/change-applications-starting-activity
