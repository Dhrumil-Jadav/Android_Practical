package com.example.practical;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CountryDB extends AppCompatActivity {

    EditText etShort, etName;
    Button btnInsert, btnRetrieve;
    TextView txtResult;

    MyDbHelper helper;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_country_db);

        etShort = findViewById(R.id.etShort);
        etName = findViewById(R.id.etName);
        btnInsert = findViewById(R.id.btnInsert);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        txtResult = findViewById(R.id.txtResult);

        helper = new MyDbHelper(this);

        // INSERT
        btnInsert.setOnClickListener(v -> {

            SQLiteDatabase db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("shortName", etShort.getText().toString());
            values.put("name", etName.getText().toString());
            db.insert("country", null, values);
            Toast.makeText(this,
                    "Country Inserted",
                    Toast.LENGTH_SHORT).show();
        });

        // RETRIEVE
        btnRetrieve.setOnClickListener(v -> {
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM country", null);
            String result = "";

            while (c.moveToNext()) {
                String shortName = c.getString(0);
                String name = c.getString(1);
                result = result + shortName + " - " + name + "\n";
            }
            c.close();
            txtResult.setText(result);
        });
    }
}