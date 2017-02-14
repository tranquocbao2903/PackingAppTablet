package com.xyz.packingapptablet.Activities;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xyz.packingapptablet.R;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
//        IntentFilter intentFilter = new IntentFilter(
//                "android.intent.action.INCOMMING_FRAGMENT");
//
//        mReceiver = new BroadcastReceiver() {
//
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                //extract our message from intent
//                String message_from_incomming = intent.getStringExtra("new_guest_comming");
//                //log our message value
//                Toast.makeText(context, message_from_incomming + " want to park at your garage", Toast.LENGTH_SHORT).show();
//
//            }
//        };
//        //registering our receiver
//        this.registerReceiver(mReceiver, intentFilter);

    }
}
