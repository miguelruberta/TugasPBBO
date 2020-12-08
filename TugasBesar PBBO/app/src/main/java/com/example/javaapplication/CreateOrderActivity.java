
package com.example.javaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaapplication.DBController.DBHelperOrder;
import com.example.javaapplication.Model.Customer.Customer;
import com.example.javaapplication.Model.Customer.Order;
import com.example.javaapplication.Model.Vendor.Kaos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerKain;
    private Spinner spinnerWarna;
    private Spinner spinnerSablon;

    private ArrayAdapter<String> adapterKain;
    private ArrayAdapter<String> adapterWarna;
    private ArrayAdapter<String> adapterSablon;

    private EditText inputS;
    private EditText inputM;
    private EditText inputL;
    private EditText inputXL;

    private Customer customer = new Customer();
    private Order order = new Order();
    private Kaos kaos = new Kaos();

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
    private int totalPrice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        if (getIntent().getExtras() != null) {
            customer = getIntent().getParcelableExtra("customer");
        }
        db = new DBHelperOrder(this);

        ImageButton btnBeranda = (ImageButton) findViewById(R.id.homeButton);
        ImageButton btnHistory = (ImageButton) findViewById(R.id.historyButton);
        ImageButton btnOrder = (ImageButton) findViewById(R.id.orderButton);
        ImageButton btnProfile = (ImageButton) findViewById(R.id.profileButton);

        spinnerKain = findViewById(R.id.spinner_kain);
        adapterKain = new ArrayAdapter(CreateOrderActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.jenis_kain));
        adapterKain.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKain.setAdapter(adapterKain);
        spinnerKain.setOnItemSelectedListener(this);

        spinnerWarna = findViewById(R.id.spinner_warna);
        adapterWarna = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.warna_kain));
        adapterWarna.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKain.setAdapter(adapterWarna);
        spinnerWarna.setOnItemSelectedListener(this);

        spinnerSablon = findViewById(R.id.spinner_sablon);
        adapterSablon = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.jenis_sablon));
        adapterSablon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKain.setAdapter(adapterSablon);
        spinnerSablon.setOnItemSelectedListener(this);

        inputS = findViewById(R.id.input_s);
        inputM = findViewById(R.id.input_m);
        inputL = findViewById(R.id.input_l);
        inputXL = findViewById(R.id.input_xl);

        btnPesan = findViewById(R.id.pesanButton);

        btnBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBeranda(customer);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToOrder(customer);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfile(customer);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHistory(customer);
            }
        });

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                String date1 = formater.format(date);
                idCustomer = customer.getId();

                Kaos kaos = new Kaos(spinnerKain.getSelectedItem().toString(),spinnerWarna.getSelectedItem().toString());
                stringSablon = spinnerSablon.getSelectedItem().toString();
                S = Integer.parseInt(inputS.getText().toString());
                M = Integer.parseInt(inputM.getText().toString());
                L = Integer.parseInt(inputL.getText().toString());
                XL = Integer.parseInt(inputXL.getText().toString());
                totalOrder = S + M + L + XL;

                if (totalOrder > 12) {
                    if (stringKain == "Cotton Combed 30s Premium") {
                        totalPrice += totalOrder * 45000;
                    } else if (stringKain == "Cotton Combed 30s") {
                        totalPrice += totalOrder * 27500;
                    } else if (stringKain == "Cotton Combed 24s") {
                        totalPrice += totalOrder * 30000;
                    } else if (stringKain == "Cotton Combed 20s") {
                        totalPrice += totalOrder * 35000;
                    } else {
                        totalPrice += totalOrder * 27500;
                    }

                    if (stringSablon == "Plastisol") {
                        totalPrice += totalOrder * 25000;
                    } else if (stringSablon == "Discharge") {
                        totalPrice += totalOrder * 30000;
                    } else {
                        totalPrice += totalOrder * 40000;
                    }

                    Order order = new Order(1,totalOrder,kaos,stringSablon,date1,totalPrice,"Diterima",customer);
                    boolean status = db.addOrder("", order.getJumlahOrder(), order.getKaos().getTipeKain(), order.getKaos().getWarna(), S, M, L, XL,
                            order.getSablon(), order.getTanggal(), order.getTotalPrice(), order.getStatus(),order.getCust().getId());

                    if (status) {
                        Toast.makeText(CreateOrderActivity.this, "Insert Order berhasil", Toast.LENGTH_SHORT).show();
                        goToHistory(customer);
                    } else {
                        Toast.makeText(CreateOrderActivity.this, "Insert Order gagal", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CreateOrderActivity.this, "Minimum order tidak tercapai ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner_kain) {
            String kain = parent.getItemAtPosition(position).toString();
        } else if (parent.getId() == R.id.spinner_warna) {
            String warna = parent.getItemAtPosition(position).toString();
        } else {
            String sablon = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    public void goToBeranda(Customer customer) {
        Intent intent = new Intent(this, BerandaActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToProfile(Customer customer) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToOrder(Customer customer) {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

        public void goToHistory(Customer customer){
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }
}