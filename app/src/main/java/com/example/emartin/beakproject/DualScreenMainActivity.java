package com.example.emartin.beakproject;

//Two fragments in Activity
//http://stackoverflow.com/questions/17580593/android-two-fragments-in-same-activity
//http://stackoverflow.com/questions/19722979/implementing-multiple-fragments-in-a-single-activity-dynamically
//https://developer.android.com/training/basics/fragments/communicating.html
//https://developer.android.com/training/basics/fragments/fragment-ui.html
//http://www.vogella.com/tutorials/AndroidFragments/article.html
//https://teamtreehouse.com/community/one-activity-two-fragments
//https://developer.android.com/guide/components/fragments.html
//http://www.cs.dartmouth.edu/~campbell/cs65/lecture09/lecture09.html
//https://www.reddit.com/r/androiddev/comments/2wsb9w/single_activity_multiple_fragments_architecture/

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class DualScreenMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dual_screen_main_activity);

    }

}