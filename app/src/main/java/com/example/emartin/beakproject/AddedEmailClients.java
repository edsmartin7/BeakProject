package com.example.emartin.beakproject;


import android.app.Activity;
import android.view.View;
import android.widget.ListView;

public class AddedEmailClients extends DualScreenMainActivity {

    OnClientSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnClientSelectedListener {
        public void onArticleSelected(int position);
    }

    /*
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnClientSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
    */

    /*
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Send the event to the host activity
        mCallback.onArticleSelected(position);
    }
    */

}
