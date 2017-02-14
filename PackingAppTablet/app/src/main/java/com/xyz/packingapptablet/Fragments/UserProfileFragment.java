package com.xyz.packingapptablet.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xyz.packingapptablet.Models.UserModel;
import com.xyz.packingapptablet.R;

/**
 * Created by THUAN on 14/02/2017.
 */

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
    }

    private BroadcastReceiver mReceiver;

    TextView userprofile_name_textview;
    TextView userprofile_contact_textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        userprofile_name_textview = (TextView) view.findViewById(R.id.userprofile_name_textview);
        userprofile_contact_textview = (TextView) view.findViewById(R.id.userprofile_contact_textview);
        ImageView btnBack = (ImageView) view.findViewById(R.id.userprofile_back_button);
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

    @Override
    public void onStart() {
        super.onStart();
        UserModel userModel= (UserModel)getArguments().getSerializable("userModel");
        assert userModel != null;
        Toast.makeText(getActivity(), userModel.getName(), Toast.LENGTH_SHORT).show();
        userprofile_name_textview.setText(userModel.getName());
        userprofile_contact_textview.setText(userModel.getContact());
    }

}
