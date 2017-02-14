package com.xyz.packingapptablet.BroadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by bao on 2/14/17.
 */

public class PackingAppBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();
        if (extras != null) {
            if(extras.containsKey("dataReceived")){

            }
        }

    }
}
