package com.example.practical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = findViewById(R.id.btn_login);
        EditText etUnm = findViewById(R.id.et_uname);
        EditText etPwd = findViewById(R.id.et_pwd);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etUnm.getText().toString();
                String password = etPwd.getText().toString();

                if (name.equals("dhrumil") && password.equals("dj625")){
                    Intent i = new Intent(Login.this, Home.class);
                    i.putExtra("uname",name);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Login.this, "Username or password invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}