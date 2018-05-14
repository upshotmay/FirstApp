package com.example.upshottechonologies.firstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("calling broadcast");
        Toast.makeText(context, "Broad cast Received:"+intent.getAction().toString(), Toast.LENGTH_LONG).show();
    }
}
