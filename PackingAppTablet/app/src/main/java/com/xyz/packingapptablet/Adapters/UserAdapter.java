package com.xyz.packingapptablet.Adapters;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xyz.packingapptablet.Fragments.UserProfileFragment;
import com.xyz.packingapptablet.Models.UserModel;
import com.xyz.packingapptablet.R;

import java.util.List;

/**
 * Created by bao on 2/9/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    private List<UserModel> mUsers;
    private Activity mContext;

    public UserAdapter(Activity context, List<UserModel> users) {
        mUsers = users;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }


    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView usernameTextView;
        TextView usercarTextView;
        ImageView userreliabilityImageview;
        TextView usercurrentTextView;
        Context viewHolderContext;
        private List<UserModel> users;
        ViewHolder(Context context, View itemView, List<UserModel> mUsers) {
            super(itemView);
            this.viewHolderContext = context;
            this.users = mUsers;
            usernameTextView = (TextView) itemView.findViewById(R.id.username_textview);
            usercarTextView = (TextView) itemView.findViewById(R.id.usercar_textview);
            userreliabilityImageview = (ImageView) itemView.findViewById(R.id.userreliability_imageview);
            usercurrentTextView = (TextView) itemView.findViewById(R.id.usercurrent_textview);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            UserProfileFragment userProfileFragment = new UserProfileFragment();
            Bundle bundle = new Bundle();
            int pos = getAdapterPosition();
            bundle.putSerializable("userModel",users.get(pos));
            userProfileFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = ((Activity) viewHolderContext).getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.user_container, userProfileFragment);
            fragmentTransaction.addToBackStack("User_to_Profile");
            fragmentTransaction.commit();




        }
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_user, parent, false);

        // Return a new holder instance
        return new ViewHolder(mContext, contactView,mUsers);

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
