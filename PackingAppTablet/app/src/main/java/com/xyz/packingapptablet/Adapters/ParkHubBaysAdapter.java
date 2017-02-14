package com.xyz.packingapptablet.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

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
            // if it's not recycled, initialize some attributes
            bayNumber = new Button(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(GridLayout.LayoutParams.WRAP_CONTENT, GridLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
           // bayNumber.setLayoutParams(new GridView.LayoutParams(100, 100));
            bayNumber.setLayoutParams(params);
            bayNumber.setTextSize(15);
            bayNumber.setBackgroundColor(GREEN);
            bayNumber.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Toast.makeText(context, bayNumber.getText(), Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        } else {
            bayNumber = (Button) convertView;
        }

        bayNumber.setText(parkhubBays.get(position));
        return bayNumber;
    }


}