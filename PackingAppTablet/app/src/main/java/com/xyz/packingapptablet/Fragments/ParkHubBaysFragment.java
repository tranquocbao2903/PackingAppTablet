package com.xyz.packingapptablet.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.xyz.packingapptablet.Adapters.ParkHubBaysAdapter;
import com.xyz.packingapptablet.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParkHubBaysFragment extends Fragment implements View.OnClickListener {

    ArrayList<String> parkhubBays = new ArrayList<>();

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
        initialData(pageCount);
        parhubBaysAdapter = new ParkHubBaysAdapter(getActivity(), parkhubBays);
        gvBays.setAdapter(parhubBaysAdapter);
        return view;
    }

    void createData(int page, int pageCount) {

        parkhubBays.clear();

        int realPageCount = (page * pageCount) + pageCount;

        if (realPageCount > parkhubSlots) {

            realPageCount = (page * pageCount) + parkhubSlots - ((page * pageCount));

        }

        for (int i = page * pageCount + 1; i <= realPageCount; i++) {
            parkhubBays.add(String.valueOf(i));
        }
        parhubBaysAdapter.notifyDataSetChanged();

    }

    void initialData(int pageCount) {

        for (int i = 1; i <= pageCount; i++) {
            parkhubBays.add(i + "");
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.next_parkhub_bay_button:

                if (pageNumber < (parkhubSlots / pageCount)) {
                    pageNumber = pageNumber + 1;
                    pagenumberTextView.setText((pageNumber + 1) + "");
                    createData(pageNumber, pageCount);
                }

                break;

            case R.id.previous_parkhub_bay_button:

                if (pageNumber > 0) {
                    pageNumber = pageNumber - 1;
                    pagenumberTextView.setText((pageNumber + 1) + "");
                    createData(pageNumber, pageCount);
                }

                break;

        }

    }
}
