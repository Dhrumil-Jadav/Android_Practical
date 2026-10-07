package com.example.practical;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class ContentProviderEx extends AppCompatActivity {

    ListView list;
    ArrayList<String> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_content_provider_ex);

        list = findViewById(R.id.list);

        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    1);

        } else {
            readContacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] results) {

        super.onRequestPermissionsResult(
                requestCode, permissions, results);

        if (requestCode == 1 &&
                results.length > 0 &&
                results[0] == PackageManager.PERMISSION_GRANTED) {

            readContacts();

        } else {
            Toast.makeText(
                    this,
                    "Permission Denied",
                    Toast.LENGTH_SHORT).show();
        }
    }
    void readContacts() {

        Cursor c = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                null);

        while (c.moveToNext()) {

            String name = c.getString(
                    c.getColumnIndexOrThrow(
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            String number = c.getString(
                    c.getColumnIndexOrThrow(
                            ContactsContract.CommonDataKinds.Phone.NUMBER));

            contacts.add(name + " : " + number);
        }

        c.close();

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        contacts);

        list.setAdapter(adapter);
    }
}