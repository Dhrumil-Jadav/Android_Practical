package com.example.practical;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText myText;
    RadioGroup rgGender;
    CheckBox cbTerms;
    Button myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.event_handler);

        myText = findViewById(R.id.et_name);
        rgGender = findViewById(R.id.rg_gender);
        cbTerms = findViewById(R.id.cb_terms);
        myBtn = findViewById(R.id.btn_click);

        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = myText.getText().toString();
                int selectedId = rgGender.getCheckedRadioButtonId();
                RadioButton selectedRb = findViewById(selectedId);
                String gender = selectedRb.getText().toString();
                String terms;

                if (cbTerms.isChecked()) {
                    terms = "Agreed";
                } else {
                    terms = "Not Agreed";
                }

                String message = "Name: " + name + ", Gender: " + gender + ", Terms: " + terms;

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}