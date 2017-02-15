package com.xyz.packingapptablet.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

import static android.graphics.Color.GREEN;

public class ParkHubBaysAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> parkhubBays;

    public ParkHubBaysAdapter(Context c, ArrayList<String> bays) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final Button bayNumber;
        if (convertView == null) {
            bayNumber = new Button(context);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(GridLayout.LayoutParams.WRAP_CONTENT, GridLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            bayNumber.setLayoutParams(params);
            bayNumber.setTextSize(15);
            bayNumber.setBackgroundColor(GREEN);
            bayNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction("PackingAppBroadcast");
                    intent.putExtra("dataReceived", bayNumber.getText().toString());
                    context.sendBroadcast(intent);
                }
            });
        } else {
            bayNumber = (Button) convertView;
        }

        bayNumber.setText(parkhubBays.get(position));
        return bayNumber;
    }


}