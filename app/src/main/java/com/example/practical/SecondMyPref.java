package com.example.practical;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondMyPref extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_second_my_pref);

        LinearLayout layout = findViewById(R.id.mainLayout);
        TextView text = findViewById(R.id.txt);

        SharedPreferences sp =
                getSharedPreferences("MyPref", MODE_PRIVATE);

        String bg = sp.getString("bg", "Black");
        String font = sp.getString("font", "White");

        layout.setBackgroundColor(Color.parseColor(bg));
        text.setTextColor(Color.parseColor(font));
    }
}