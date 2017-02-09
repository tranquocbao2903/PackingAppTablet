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

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView usernameTextView;
        public TextView usercarTextView;
        public ImageView userreliabilityImageview;
        public TextView usercurrentTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            usernameTextView = (TextView) itemView.findViewById(R.id.username_textview);
            usercarTextView = (TextView) itemView.findViewById(R.id.usercar_textview);
            userreliabilityImageview = (ImageView) itemView.findViewById(R.id.userreliability_imageview);
            usercurrentTextView = (TextView) itemView.findViewById(R.id.usercurrent_textview);

        }

    }

    private List<UserModel> mUsers;

    private Context mContext;

    public UserAdapter(Context context, List<UserModel> users) {
        mUsers = users;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_user, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        UserModel userModel = mUsers.get(position);

        TextView usernameTextView = holder.usernameTextView;
        TextView usercarTextView = holder.usercarTextView;
        ImageView userreliabilityImageview = holder.userreliabilityImageview;
        TextView usercurrentTextView = holder.usercurrentTextView;

        String imageName = userModel.getReliability();
        int resID = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());

        userreliabilityImageview.setImageResource(resID);
        usernameTextView.setText(userModel.getName());
        usercarTextView.setText(userModel.getCar().getVehicle());
        usercurrentTextView.setText(userModel.getCar().getCurrent());

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
