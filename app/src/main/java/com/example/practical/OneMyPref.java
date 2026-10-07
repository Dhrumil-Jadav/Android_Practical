package com.example.practical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class OneMyPref extends AppCompatActivity {

    EditText etBg, etFont;
    Button btnNext;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_one_my_pref);

        etBg = findViewById(R.id.etBg);
        etFont = findViewById(R.id.etFont);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {

            SharedPreferences sp =
                    getSharedPreferences("MyPref", MODE_PRIVATE);

            sp.edit()
                    .putString("bg", etBg.getText().toString())
                    .putString("font", etFont.getText().toString())
                    .apply();

            startActivity(new Intent(OneMyPref.this, SecondMyPref.class));
        });
    }
}