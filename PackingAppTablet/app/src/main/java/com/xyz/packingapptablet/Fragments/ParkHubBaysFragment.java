package com.xyz.packingapptablet.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyz.packingapptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParkHubBaysFragment extends Fragment {


    public ParkHubBaysFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_park_hub_bays, container, false);
    }

}
