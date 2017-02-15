package com.xyz.packingapptablet.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.xyz.packingapptablet.Fragments.UserProfileFragment;
import com.xyz.packingapptablet.R;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserProfileFragment userProfileFragment = new UserProfileFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.user_container, userProfileFragment,"userProfileFragment");
        fragmentTransaction.hide(userProfileFragment);
        fragmentTransaction.addToBackStack("User_to_Profile");
        fragmentTransaction.commit();


    }


}
