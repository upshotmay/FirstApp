package com.example.upshottechonologies.firstapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class BindService extends Service {
    public static final String TAG = "BindService";
    IBinder binder = new LocalBinder();
    public BindService() {
    }
    @Override
    public void onCreate()
    {
        Log.d(TAG, "onCreate: ");
    }
    @Override
    public void onRebind(Intent intent)
    {
        Log.d(TAG, "onRebind: ");
        
       super.onRebind(intent); 
    }
    
    @Override
    public boolean onUnbind(Intent intent)
    {
        super.onUnbind(intent);
        return true;
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return binder;

    }
    public int randomNumber(int a)
    {
        Random random = new Random();
        return random.nextInt(100)+a;
    }

    public class LocalBinder extends Binder{
        BindService getService()
        {
            return BindService.this;
        }
    }
}
