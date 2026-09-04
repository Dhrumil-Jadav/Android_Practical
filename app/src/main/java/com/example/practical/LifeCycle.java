package com.example.practical;

import android.health.connect.datatypes.units.Length;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LifeCycle extends AppCompatActivity {

    @Override
    public void onCreate(Bundle S){
        super.onCreate(S);
        setContentView(R.layout.life_cycle);
        Toast.makeText(LifeCycle.this, "Application Created.", Toast.LENGTH_LONG).show();
    }

    public void onStart(){
        super.onStart();
        Toast.makeText(LifeCycle.this, "Application Started.", Toast.LENGTH_LONG).show();
    }


    public void onResume(){
        super.onResume();
        Toast.makeText(LifeCycle.this, "Application Resume.", Toast.LENGTH_LONG).show();
    }


    public void onPause(){
        super.onPause();
        Toast.makeText(LifeCycle.this, "Application Pause.", Toast.LENGTH_LONG).show();
    }


    public void onStop(){
        super.onStop();
        Toast.makeText(LifeCycle.this, "Application Stop.", Toast.LENGTH_LONG).show();
    }


    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(LifeCycle.this, "Application Destroy", Toast.LENGTH_LONG).show();
    }
}
