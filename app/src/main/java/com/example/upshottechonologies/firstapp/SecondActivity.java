package com.example.upshottechonologies.firstapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static String TAG ="SecondActivity";
    TextView mTextView;
    Button mStartService, mStopService, randomButton;
    BindService bindService;
    boolean mBound;
    Messenger messenger;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Oncrete");
        setContentView(R.layout.activity_second);
        final Intent intent = getIntent();
        String val = intent.getStringExtra("Key");
        mTextView = findViewById(R.id.textView);
        mTextView.setText(val);
        mStartService  = findViewById(R.id.StartService);
        editText = findViewById(R.id.editText);
        mStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(SecondActivity.this, MessengerService.class);
                bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                //startService(serviceIntent);
            }
        });
        mStopService = findViewById(R.id.StopService);
        mStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent1 = new Intent(SecondActivity.this, MyService.class);
              //  stopService(intent1);
            }
        });

        randomButton = findViewById(R.id.random);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBound) {
                    int value = Integer.parseInt(editText.getText().toString());
                    //randomButton.setText(bindService.randomNumber(10) + "");
                    Message message = Message.obtain(null, 0, value, 0);
                    try {
                        messenger.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.d(TAG, "onServiceConnected: ");
            //BindService.LocalBinder binder = (BindService.LocalBinder)service;
            //bindService = binder.getService();
            messenger = new Messenger(binder);
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
            mBound = false;
        }
    };
    @Override
    protected void onStart()
    {
        Log.d(TAG, "onStart: OnStart()");
        super.onStart();
    }
    @Override
    protected void onResume()
    {
        Log.d(TAG, "onStart: onResume()");
        super.onResume();
    }
    @Override
    protected void onStop()
    {
        Log.d(TAG, "onStart: onStop()");
        super.onStop();
    }
    @Override
    protected void onPause()
    {
        Log.d(TAG, "onStart: onPause()");
        super.onPause();
    }
    @Override
    protected void onDestroy()
    {
        Log.d(TAG, "onStart: onDestroy()");
        super.onDestroy();
    }
    @Override
    protected void onRestart()
    {
        Log.d(TAG, "onStart: onRestart()");
        super.onRestart();
    }
}
