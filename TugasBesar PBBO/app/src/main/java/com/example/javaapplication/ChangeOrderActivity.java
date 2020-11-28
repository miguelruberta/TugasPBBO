package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.javaapplication.Model.Vendor;

public class ChangeOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerStatus;
    private ArrayAdapter<CharSequence> adapterStatus;

    private TextView inputS;
    private TextView inputM;
    private TextView inputL;
    private TextView inputXL;

    private int idOrder;

    private ImageButton btnUbah;

    private Vendor vendor = new Vendor();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_order);

        //get intent ID_ORDER
        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                idOrder = extras.getInt("ID_ORDER");
                vendor = getIntent().getParcelableExtra("VENDOR");
            }
        } else {
            idOrder = (Integer) savedInstanceState.getSerializable("ID_ORDER");
            vendor = getIntent().getParcelableExtra("VENDOR");
        }

        //import array into spinner
        spinnerStatus = (Spinner) findViewById(R.id.spinner_kain);
        spinnerStatus.setOnItemSelectedListener(this);
        adapterStatus = new ArrayAdapter(this, android.R.layout.simple_spinner_item, R.array.status_order);
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapterStatus);

        btnUbah = (ImageButton) findViewById(R.id.simpanOrder);
        //get order detail from id
        //show text to UI
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void goToBerandaVendor(Vendor v) {

    }

    public void goToProfileVendor(Vendor v) {

    }

    public void goToOrdersVendor(Vendor v) {

    }
}