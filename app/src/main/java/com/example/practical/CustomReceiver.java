package com.example.practical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CustomReceiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_custom_receiver);

        Button btn = findViewById(R.id.btnSend);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("MY_CUSTOM_BROADCAST");
                sendBroadcast(i);
            }
        });
    }
}