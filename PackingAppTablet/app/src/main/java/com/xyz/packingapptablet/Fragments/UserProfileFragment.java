package com.xyz.packingapptablet.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xyz.packingapptablet.R;

/**
 * Created by THUAN on 14/02/2017.
 */

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ImageView btnBack = (ImageView)view.findViewById(R.id.userprofile_back_button);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    Log.i("UserProfileFragment", "popping backstack");
                    fm.popBackStack();
                }
            }
        });
        return view;
    }
}
