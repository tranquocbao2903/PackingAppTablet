package com.xyz.packingapptablet.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyz.packingapptablet.Adapters.UserAdapter;
import com.xyz.packingapptablet.Models.CarModel;
import com.xyz.packingapptablet.Models.UserModel;
import com.xyz.packingapptablet.R;

import java.util.ArrayList;

public class UserFragment extends Fragment {

    ArrayList<UserModel> users = new ArrayList();

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        RecyclerView rvUsers = (RecyclerView)view.findViewById(R.id.rvUsers);

        createData();

        UserAdapter adapter = new UserAdapter(this.getActivity(), users);

        rvUsers.setAdapter(adapter);

        rvUsers.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return view;
    }

    void createData() {
        CarModel carModel01 = new CarModel("Ford", "PWER7841", "Parked", "242", "2h 34m", "No shows");

        UserModel userModel01 = new UserModel("Bao", "0932819991", "Paypal", "confused", carModel01);

        CarModel carModel02 = new CarModel("Camry", "QWCX0932", "Parked", "242", "1h 56m", "No shows");

        UserModel userModel02 = new UserModel("Thuan", "0932615814", "MasterCard", "sad", carModel02);

        CarModel carModel03 = new CarModel("Chevorlet", "NBGF1234", "Parked", "242", "12h 20m", "No shows");

        UserModel userModel03 = new UserModel("Vi", "0908585128", "Paypal", "smile", carModel03);

        CarModel carModel04 = new CarModel("Martin 307", "KJGS4567", "Parked", "242", "3h 09m", "No shows");

        UserModel userModel04 = new UserModel("Binh", "0909124164", "Paypal", "confused", carModel04);

        CarModel carModel05 = new CarModel("Ford", "DFTY8765", "Parked", "242", "6h 12m", "No shows");

        UserModel userModel05 = new UserModel("Phuong", "0932819991", "Paypal", "sad", carModel05);

        CarModel carModel06 = new CarModel("Ford", "MNBV3542", "Parked", "242", "9h 34m", "No shows");

        UserModel userModel06 = new UserModel("Thanh", "0837623818", "Paypal", "smile", carModel06);

        CarModel carModel07 = new CarModel("Ford", "TYRE9865", "Parked", "242", "15h 26m", "No shows");

        UserModel userModel07 = new UserModel("Thien", "0839691368", "Paypal", "confused", carModel07);

        users.add(userModel01);
        users.add(userModel02);
        users.add(userModel03);
        users.add(userModel04);
        users.add(userModel05);
        users.add(userModel06);
        users.add(userModel07);
        users.add(userModel01);
        users.add(userModel02);
        users.add(userModel03);
        users.add(userModel04);
        users.add(userModel05);
        users.add(userModel06);
        users.add(userModel07);
        users.add(userModel01);
        users.add(userModel02);
        users.add(userModel03);
        users.add(userModel04);
        users.add(userModel05);
        users.add(userModel06);
        users.add(userModel07);
    }

}
