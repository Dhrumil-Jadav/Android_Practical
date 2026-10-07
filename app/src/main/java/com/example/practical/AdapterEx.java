package com.example.practical;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdapterEx extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<>();

    Spinner spinner;
    ListView lstview;
    EditText etItem;
    Button btnAdd;

    ArrayAdapter<String> spnAdapter;
    ArrayAdapter<String> lstAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_ex);
        etItem = findViewById(R.id.etItem);
        btnAdd = findViewById(R.id.btnAdd);

        spinner = findViewById(R.id.spn_list);
        spnAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                items);

        spnAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spnAdapter);

        // Spinner selection
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        Toast.makeText(
                                AdapterEx.this,
                                "Spinner " + items.get(position) + " is selected",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        // ListView
        lstview = findViewById(R.id.lst);

        lstAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items);

        lstview.setAdapter(lstAdapter);

        // ListView selection
        lstview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        Toast.makeText(
                                AdapterEx.this,
                                "ListView " + items.get(position) + " is selected",
                                Toast.LENGTH_LONG).show();
                    }
                });

        // ADD operation
        btnAdd.setOnClickListener(v -> {

            String item = etItem.getText().toString();

            if (!item.isEmpty()) {

                items.add(item);

                spnAdapter.notifyDataSetChanged();
                lstAdapter.notifyDataSetChanged();

                etItem.setText("");

                Toast.makeText(
                        AdapterEx.this,
                        "Item Added",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}