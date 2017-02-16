package com.xyz.packingapptablet.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.xyz.packingapptablet.Models.BayModel;

import java.util.ArrayList;

public class ParkHubBaysAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<BayModel> parkhubBays;

    public ParkHubBaysAdapter(Context c, ArrayList<BayModel> bays) {
        context = c;
        parkhubBays = bays;
    }

    public int getCount() {
        return parkhubBays.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Button bayNumber;

            bayNumber = new Button(context);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(GridLayout.LayoutParams.WRAP_CONTENT, GridLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            bayNumber.setLayoutParams(params);
            bayNumber.setTextSize(15);
            bayNumber.setBackgroundColor(parkhubBays.get(position).getStateColor());
            bayNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    BayModel editedBayModel = parkhubBays.get(position);
                    editedBayModel.setState(!editedBayModel.isState());
                    editedBayModel.setStateColor(editedBayModel.isState() ? Color.parseColor("#ff9933") : Color.parseColor("#009933"));
                    editedBayModel.setBayNumber(parkhubBays.get(position).getBayNumber());
                    bayNumber.setBackgroundColor(editedBayModel.getStateColor());

                    Intent intent = new Intent();
                    intent.setAction("PackingAppBroadcast");
                    intent.putExtra("editedBayModel", editedBayModel);
                    context.sendBroadcast(intent);

                }
            });


        bayNumber.setText(String.valueOf(parkhubBays.get(position).getBayNumber()));
        return bayNumber;
    }


}