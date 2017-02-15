package com.xyz.packingapptablet.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

public class UserProfileFragment extends android.support.v4.app.Fragment {

    public UserProfileFragment() {
    }

    private BroadcastReceiver mReceiver;
    TextView userprofile_name_textview;
    TextView userprofile_contact_textview;
    TextView userprofile_vehicle_textview;
    TextView userprofile_cartype_textview;
    TextView userprofile_current_textview;
    TextView userprofile_noshows_textview;
    TextView userprofile_status_textview;
    TextView userprofile_baynumber_textview;
    TextView userprofile_payment_textview;
    ImageView userprofile_reliability_imageview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        initReference(view);
        ImageView btnBack = (ImageView) view.findViewById(R.id.userprofile_back_button);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment userProfileFragment = (getActivity()).getSupportFragmentManager().findFragmentByTag("userProfileFragment");
                FragmentTransaction fragmentTransaction = (getActivity()).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(0, R.anim.exit_anim);
                fragmentTransaction.hide(userProfileFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void initReference(View view) {
        userprofile_name_textview = (TextView) view.findViewById(R.id.userprofile_name_textview);
        userprofile_contact_textview = (TextView) view.findViewById(R.id.userprofile_contact_textview);
        userprofile_vehicle_textview = (TextView) view.findViewById(R.id.userprofile_vehicle_textview);
        userprofile_cartype_textview = (TextView) view.findViewById(R.id.userprofile_cartype_textview);
        userprofile_current_textview = (TextView) view.findViewById(R.id.userprofile_current_textview);
        userprofile_noshows_textview = (TextView) view.findViewById(R.id.userprofile_noshows_textview);
        userprofile_status_textview = (TextView) view.findViewById(R.id.userprofile_status_textview);
        userprofile_baynumber_textview = (TextView) view.findViewById(R.id.userprofile_baynumber_textview);
        userprofile_payment_textview = (TextView) view.findViewById(R.id.userprofile_payment_textview);
        userprofile_reliability_imageview = (ImageView) view.findViewById(R.id.userprofile_reliability_imageview);
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(
                "PackingAppBroadcast");
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Fragment userProfileFragment = (getActivity()).getSupportFragmentManager().findFragmentByTag("userProfileFragment");
                FragmentTransaction fragmentTransaction = (getActivity()).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_anim, 0);
                fragmentTransaction.show(userProfileFragment);
                fragmentTransaction.commit();

                updateUI();
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    UserModel user = ((UserModel) extras.get("userModel"));
                    if (extras.containsKey("userModel")) {
                        userprofile_name_textview.setText("Name: " + user.getName());
                        userprofile_contact_textview.setText("Contact: " + user.getContact());
                        userprofile_vehicle_textview.setText("Vehicle: " + user.getCar().getVehicle());
                        userprofile_cartype_textview.setText("Car Type: " + user.getCar().getType());
                        userprofile_current_textview.setText("Current: " + user.getCar().getCurrent());
                        userprofile_noshows_textview.setText("No Shows: " + user.getCar().getNoShow());
                        userprofile_status_textview.setText("Status: " + user.getCar().getStatus());
                        userprofile_baynumber_textview.setText("Bay Nr: " + user.getCar().getBayNr());
                        userprofile_payment_textview.setText("Payment: " + user.getPayment());

                        String imageName = user.getReliability();
                        int resID = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
                        userprofile_reliability_imageview.setImageResource(resID);
                    }
                }

            }
        };
        getActivity().registerReceiver(mReceiver, intentFilter);


    }

    void updateUI() {
        Toast.makeText(getContext(), "UI Profile updated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(mReceiver);

    }
}
