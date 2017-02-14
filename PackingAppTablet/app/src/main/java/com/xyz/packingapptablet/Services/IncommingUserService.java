package com.xyz.packingapptablet.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by bao on 2/14/17.
 */

public class IncommingUserService extends Service {

    private static String TAG = "IncommingService Log";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "IncommingUserService started");
        String licensePlates = intent.getStringExtra("licensePlates");

        if (licensePlates != null) {
            Intent i = new Intent("android.intent.action.INCOMMING_FRAGMENT").putExtra("new_guest_comming", licensePlates);
            this.sendBroadcast(i);
            this.stopSelf();
        }

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "IncommingUserService destroyed");
    }
}
