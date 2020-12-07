package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.javaapplication.DBController.DBHelper;
import com.example.javaapplication.DBController.DBHelperOrder;
import com.example.javaapplication.Model.Customer.Customer;

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

    private ImageButton btnPesan;

    private DBHelperOrder db;

    private String stringKain;
    private String stringWarna;
    private String stringSablon;
    private int S;
    private int M;
    private int L;
    private int XL;
    private int idCustomer;
    private int totalOrder = 0;
    private int totalPrice = 0 ;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        if(getIntent().getExtras() != null) {
            customer = getIntent().getParcelableExtra("customer");
        }
//        db = new DBHelperOrder(this);

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

        btnPesan = (ImageButton) findViewById(R.id.pesanButton);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringKain = spinnerKain.getSelectedItem().toString();
                stringWarna = spinnerWarna.getSelectedItem().toString();
                stringSablon = spinnerSablon.getSelectedItem().toString();
                S = Integer.parseInt(inputS.getText().toString());
                M = Integer.parseInt(inputM.getText().toString());
                L = Integer.parseInt(inputL.getText().toString());
                XL = Integer.parseInt(inputXL.getText().toString());
                totalOrder = S+M+L+XL;

                if(stringKain == "Cotton Combed 30s Premium"){
                    totalPrice += totalOrder*45000;
                }else if (stringKain == "Cotton Combed 30s"){
                    totalPrice += totalOrder*27500;
                }else if (stringKain == "Cotton Combed 24s"){
                    totalPrice += totalOrder*30000;
                }else if (stringKain == "Cotton Combed 20s"){
                    totalPrice += totalOrder*35000;
                }else{
                    totalPrice += totalOrder*27500;
                }

                if(stringSablon == "Plastisol"){
                    totalPrice += totalOrder*25000;
                }else if (stringSablon == "Discharge"){
                    totalPrice += totalOrder*30000;
                }else{
                    totalPrice += totalOrder*40000;
                }


            }
        });
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



    public void goToBeranda(Customer customer){
        Intent intent = new Intent(this, BerandaActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToProfile(Customer customer) {
        Intent intent = new Intent(this, BerandaActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToOrders(Customer customer) {
        Intent intent = new Intent(this, BerandaActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }
}