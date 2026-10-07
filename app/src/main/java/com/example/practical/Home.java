package com.example.practical;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new MyReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.intent.action.BATTERY_LOW");
        filter.addAction("android.intent.action.AIRPLANE_MODE");
        filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");

        registerReceiver(receiver, filter, RECEIVER_EXPORTED);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(receiver);
    }
}