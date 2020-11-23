package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.javaapplication.Model.Customer;

import java.lang.reflect.Array;

public class CreateOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerKain;
    private Spinner spinnerWarna;
    private Spinner spinnerSablon;

    private ArrayAdapter<CharSequence> adapterKain;
    private ArrayAdapter<CharSequence> adapterWarna;
    private ArrayAdapter<CharSequence> adapterSablon;

    private EditText inputS;
    private EditText inputM;
    private EditText inputL;
    private EditText inputXL;

    private Customer customer = new Customer();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        if(getIntent().getExtras() != null) {
            customer = getIntent().getParcelableExtra("customer");
        }

        spinnerKain = (Spinner) findViewById(R.id.spinner_kain);
        spinnerKain.setOnItemSelectedListener(this);
        adapterKain = new ArrayAdapter(this, android.R.layout.simple_spinner_item, R.array.jenis_kain);
        adapterKain.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKain.setAdapter(adapterKain);

        spinnerWarna = (Spinner) findViewById(R.id.spinner_warna);
        spinnerWarna.setOnItemSelectedListener(this);
        adapterWarna = new ArrayAdapter(this, android.R.layout.simple_spinner_item, R.array.warna_kain);
        adapterWarna.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKain.setAdapter(adapterWarna);

        spinnerSablon = (Spinner) findViewById(R.id.spinner_sablon);
        spinnerSablon.setOnItemSelectedListener(this);
        adapterSablon = new ArrayAdapter(this, android.R.layout.simple_spinner_item, R.array.jenis_sablon);
        adapterSablon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKain.setAdapter(adapterSablon);

        inputS = (EditText) findViewById(R.id.input_s);
        inputM = (EditText) findViewById(R.id.input_m);
        inputL = (EditText) findViewById(R.id.input_l);
        inputXL = (EditText) findViewById(R.id.input_xl);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner_kain) {
            String kain = (String) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), kain , Toast.LENGTH_LONG).show();
        } else if (parent.getId() == R.id.spinner_warna) {
            String warna = (String) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), warna , Toast.LENGTH_LONG).show();
        } else {
            String sablon = (String) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), sablon , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}