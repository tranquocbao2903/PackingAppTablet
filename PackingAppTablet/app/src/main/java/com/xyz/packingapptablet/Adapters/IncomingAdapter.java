package com.xyz.packingapptablet.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xyz.packingapptablet.Models.UserModel;
import com.xyz.packingapptablet.R;

import java.util.List;

/**
 * Created by bao on 2/9/17.
 */

public class IncomingAdapter extends RecyclerView.Adapter<IncomingAdapter.ViewHolder> {

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView usernameTextView;
        TextView usercarTextView;
        ImageView userreliabilityImageview;
        TextView userdistanceincomingTextView;

        ViewHolder(View itemView) {
            super(itemView);

            usernameTextView = (TextView) itemView.findViewById(R.id.usernameincoming_textview);
            usercarTextView = (TextView) itemView.findViewById(R.id.usercarincoming_textview);
            userreliabilityImageview = (ImageView) itemView.findViewById(R.id.userreliabilityincoming_imageview);
            userdistanceincomingTextView = (TextView) itemView.findViewById(R.id.userdistanceincoming_textview);

        }

    }

    private List<UserModel> mUsers;

    private Context mContext;

    public IncomingAdapter(Context context, List<UserModel> users) {
        mUsers = users;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_incoming, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        UserModel userModel = mUsers.get(position);

        TextView usernameTextView = holder.usernameTextView;
        TextView usercarTextView = holder.usercarTextView;
        ImageView userreliabilityImageview = holder.userreliabilityImageview;
        TextView userdistanceincomingTextView = holder.userdistanceincomingTextView;

        String imageName = userModel.getReliability();
        int resID = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());

        userreliabilityImageview.setImageResource(resID);
        usernameTextView.setText(userModel.getName());
        usercarTextView.setText(userModel.getCar().getVehicle());
        userdistanceincomingTextView.setText(userModel.getDistance());

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
