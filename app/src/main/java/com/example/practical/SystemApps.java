package com.example.practical;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SystemApps extends AppCompatActivity {

    EditText etNumber, etUrl, etEmail;
    Button btnDial, btnWeb, btnEmail, btnCamera;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_system_apps);

        etNumber = findViewById(R.id.etNumber);
        etUrl = findViewById(R.id.etUrl);
        etEmail = findViewById(R.id.etEmail);

        btnDial = findViewById(R.id.btnDial);
        btnWeb = findViewById(R.id.btnWeb);
        btnEmail = findViewById(R.id.btnEmail);
        btnCamera = findViewById(R.id.btnCamera);

        // Dial
        btnDial.setOnClickListener(v -> {

            String number = etNumber.getText().toString();

            Intent i = new Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:" + number));

            startActivity(i);
        });

        // Open Web Page
        btnWeb.setOnClickListener(v -> {

            String url = etUrl.getText().toString();

            Intent i = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url));

            startActivity(i);
        });

        // Send Email
        btnEmail.setOnClickListener(v -> {

            String email = etEmail.getText().toString();

            Intent i = new Intent(Intent.ACTION_SENDTO);

            i.setData(Uri.parse("mailto:" + email));

            i.putExtra(Intent.EXTRA_SUBJECT, "Hello");

            startActivity(i);
        });

        // Camera
        btnCamera.setOnClickListener(v -> {

            Intent i = new Intent(
                    MediaStore.ACTION_IMAGE_CAPTURE);

            startActivity(i);
        });
    }
}