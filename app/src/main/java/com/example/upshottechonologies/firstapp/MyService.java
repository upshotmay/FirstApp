package com.example.upshottechonologies.firstapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static String TAG = "Myservice";
    MediaPlayer mp;
    public MyService() {
    }
    @Override
    public void onCreate()
    {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flag, int startId)
    {
        Log.d(TAG, "onStartCommand: called");
        mp = MediaPlayer.create(this, R.raw.song);
        mp.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        mp.stop();
        Log.d(TAG, "onDestroy: called");
        super.onDestroy();
    }
}
