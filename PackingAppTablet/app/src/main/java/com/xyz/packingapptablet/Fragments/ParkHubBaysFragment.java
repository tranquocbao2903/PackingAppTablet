package com.xyz.packingapptablet.Fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.xyz.packingapptablet.Adapters.ParkHubBaysAdapter;
import com.xyz.packingapptablet.Models.BayModel;
import com.xyz.packingapptablet.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParkHubBaysFragment extends Fragment implements View.OnClickListener {

    ArrayList<BayModel> parkhubBaysData = new ArrayList<>();
    ArrayList<BayModel> parkhubBays = new ArrayList<>();

    GridView gvBays;
    Button buttonPreviousPage;
    Button buttonNextPage;
    TextView pagenumberTextView;

    ParkHubBaysAdapter parhubBaysAdapter;

    int pageNumber = 0;
    int pageCount = 30;
    int parkhubSlots = 100;

    public ParkHubBaysFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_park_hub_bays, container, false);
        gvBays = (GridView) view.findViewById(R.id.parkhubBays);
        buttonNextPage = (Button) view.findViewById(R.id.next_parkhub_bay_button);
        buttonPreviousPage = (Button) view.findViewById(R.id.previous_parkhub_bay_button);
        pagenumberTextView = (TextView) view.findViewById(R.id.pagenumber_parkhub_textview);

        buttonNextPage.setOnClickListener(this);
        buttonPreviousPage.setOnClickListener(this);

        pagenumberTextView.setText((pageNumber + 1) + "");
        getParkhubData();
        createData(pageCount);
        parhubBaysAdapter = new ParkHubBaysAdapter(getActivity(), parkhubBays);
        gvBays.setAdapter(parhubBaysAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter(
                "PackingAppBroadcast");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    if (extras.containsKey("editedBayModel")) {
                        BayModel bayModel = ((BayModel) extras.get("editedBayModel"));
                        parkhubBaysData.set(bayModel.getBayNumber(), bayModel);
                        //Toast.makeText(context, parkhubBaysData.get(bayModel.getBayNumber()).getBayNumber() + "'", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
        getActivity().registerReceiver(broadcastReceiver, intentFilter);

    }

    //    void createData(int page, int pageCount) {
//
//        parkhubBays.clear();
//
//        int realPageCount = (page * pageCount) + pageCount;
//
//        if (realPageCount > parkhubSlots) {
//
//            realPageCount = (page * pageCount) + parkhubSlots - ((page * pageCount));
//
//        }
//
//        for (int i = page * pageCount + 1; i <= realPageCount; i++) {
//            //parkhubBays.add(String.valueOf(i));
//        }
//        parhubBaysAdapter.notifyDataSetChanged();
//
//    }

    void getParkhubData() {
        for (int i = 0; i < parkhubSlots; i++) {
            BayModel bayModel = new BayModel(false, Color.parseColor("#009933"), i);
            parkhubBaysData.add(bayModel);
        }
    }

    void initialBaysData(int pageNumber, int pageCount) {
        parkhubBays.clear();

        int realPageCount = (pageNumber * pageCount) + pageCount;

        if (realPageCount > parkhubSlots) {

            realPageCount = (pageNumber * pageCount) + parkhubSlots - ((pageNumber * pageCount));

        }

        for (int i = pageNumber * pageCount; i < realPageCount; i++) {
            parkhubBays.add(parkhubBaysData.get(i));
        }
        parhubBaysAdapter.notifyDataSetChanged();
    }

    void createData(int pageCount) {
        for(int i = 0; i < pageCount; i++) {
            parkhubBays.add(parkhubBaysData.get(i));
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.next_parkhub_bay_button:

                if (pageNumber < (parkhubSlots / pageCount)) {
                    pageNumber = pageNumber + 1;
                    pagenumberTextView.setText((pageNumber + 1) + "");
                    initialBaysData(pageNumber, pageCount);
                }

                break;

            case R.id.previous_parkhub_bay_button:

                if (pageNumber > 0) {
                    pageNumber = pageNumber - 1;
                    pagenumberTextView.setText((pageNumber + 1) + "");
                    initialBaysData(pageNumber, pageCount);
                }

                break;

        }

    }
}
