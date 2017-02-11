package com.xyz.packingapptablet.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public IncomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_incoming, container, false);

        RecyclerView rvIncoming = (RecyclerView) view.findViewById(R.id.rvIncoming);

        createData();

        IncomingAdapter adapter = new IncomingAdapter(this.getActivity(), users);

        rvIncoming.setAdapter(adapter);

        rvIncoming.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
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