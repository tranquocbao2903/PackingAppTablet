package com.xyz.packingapptablet.Fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xyz.packingapptablet.Adapters.IncomingAdapter;
import com.xyz.packingapptablet.Models.CarModel;
import com.xyz.packingapptablet.Models.UserModel;
import com.xyz.packingapptablet.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncomingFragment extends Fragment {

    ArrayList<UserModel> users = new ArrayList<>();

    private BroadcastReceiver mReceiver;
    RecyclerView rvIncoming;

    public IncomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_incoming, container, false);
        initReference(view);
        createData();
        IncomingAdapter adapter = new IncomingAdapter(this.getActivity(), users);
        rvIncoming.setAdapter(adapter);
        rvIncoming.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
    }


    private void initReference(View view) {
        rvIncoming = (RecyclerView) view.findViewById(R.id.rvIncoming);

    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(
                "PackingAppBroadcast");
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //updateUI();
            }
        };
        getActivity().registerReceiver(mReceiver, intentFilter);
    }

    void updateUI() {
        Toast.makeText(getContext(), "UI updated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(mReceiver);

    }

    void createData() {
        CarModel carModel01 = new CarModel("Dylan", "ABC12345", "Parked", "242", "2h 34m", "No shows");
        UserModel userModel01 = new UserModel("Bao", "0932819991", "Paypal", "confused", carModel01, "15.9m");
        CarModel carModel02 = new CarModel("BMW", "XYZ78912", "Parked", "242", "1h 56m", "No shows");
        UserModel userModel02 = new UserModel("Thuan", "0932615814", "MasterCard", "sad", carModel02, "20.65m");
        users.add(userModel01);
        users.add(userModel02);

    }

}
