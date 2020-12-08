package com.example.javaapplication.VendorView;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.javaapplication.DBController.DBHelperVendor;
import com.example.javaapplication.Model.Customer.Order;
import com.example.javaapplication.Model.Vendor.Vendor;
import com.example.javaapplication.R;

public class ChangeOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DBHelperVendor db = new DBHelperVendor(this);
    private Spinner spinnerStatus;
    private ArrayAdapter<String> adapterStatus;

    private TextView warna;
    private TextView jumlah;
    private TextView jenis;
    private TextView sablon;
    private TextView inputTotal;

    private int idOrder;
    private ImageButton btnUbah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_order);

        warna = (TextView) findViewById(R.id.warnaKaos);
        jumlah = (TextView) findViewById(R.id.jumlahKaos);
        jenis = (TextView) findViewById(R.id.jenisKaos);
        sablon = (TextView) findViewById(R.id.jenisSablon);
        inputTotal = (TextView) findViewById(R.id.input_order);

        //get intent ID_ORDER
        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                idOrder = extras.getInt("ID_ORDER");
            }
        } else {
            idOrder = (Integer) savedInstanceState.getSerializable("ID_ORDER");
        }

//        System.out.println("id order : " + idOrder);
        Order order = db.getOrderObject(idOrder);
        String stringWarna = order.getKaos().getWarna();
        String stringJumlah = String.valueOf(order.getJumlahOrder());
        String stringJenis = order.getKaos().getTipeKain();
        String stringSablon = order.getSablon();
        String stringTotal = String.valueOf(order.getJumlahOrder());

        warna.setText(stringWarna);
        jumlah.setText(stringJumlah);
        jenis.setText(stringJenis);
        sablon.setText(stringSablon);
        inputTotal.setText(stringTotal);

        //import array into spinner
        spinnerStatus = findViewById(R.id.spinner_status_order);
        adapterStatus = new ArrayAdapter(ChangeOrderActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.status_order));
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapterStatus);
        spinnerStatus.setOnItemSelectedListener(this);

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