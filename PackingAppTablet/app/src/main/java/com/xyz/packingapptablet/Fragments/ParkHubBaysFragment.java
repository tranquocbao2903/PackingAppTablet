package com.xyz.packingapptablet.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyz.packingapptablet.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParkHubBaysFragment extends Fragment {

    ArrayList<String> parkhubBays = new ArrayList<>();

    public ParkHubBaysFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_park_hub_bays, container, false);

//        GridView gvBays = (GridView) view.findViewById(R.id.parkhubBays);
//
//        createData();
//
//        ParkHubBaysAdapter parhubBaysAdapter = new ParkHubBaysAdapter(getActivity(),parkhubBays);
//        gvBays.setAdapter(parhubBaysAdapter);

        return view;
    }

    void createData(){
        for(int i = 0;i<25;i++){
            parkhubBays.add(String.valueOf(i));
        }
    }

}
