package com.example.upshottechonologies.firstapp;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

public class MessengerService extends Service {
    public MessengerService() {
    }
    class IncomingHandler extends Handler{
        @Override
        public void handleMessage(Message msg)
        {
            System.out.println("Message recieved from client:"+msg.arg1);
        }
    }

    Messenger messenger = new Messenger(new IncomingHandler());


    @Override
    public IBinder onBind(Intent intent) {
      return messenger.getBinder();
    }
}
