package com.xyz.packingapptablet.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.xyz.packingapptablet.R;

import java.util.ArrayList;

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

    // create a new ImageView for each item referenced by the Adapter
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView bayNumber;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            bayNumber = new TextView(context);
            bayNumber.setLayoutParams(new GridView.LayoutParams(200, 200));
            bayNumber.setTextSize(26);
            bayNumber.setTextAlignment(View.TEXT_ALIGNMENT_INHERIT);
            bayNumber.setBackgroundResource(R.drawable.gridview_border);
        } else {
            bayNumber = (TextView) convertView;
        }

        bayNumber.setText(parkhubBays.get(position));
        return bayNumber;
    }


}