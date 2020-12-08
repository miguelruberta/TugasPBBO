package com.example.javaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaapplication.DBController.DBHelper;
import com.example.javaapplication.Model.Customer.Customer;

public class EditProfileActivity extends AppCompatActivity {
    private TextView nama;
    private EditText email;
    private EditText notelp;
    private EditText password;
    private String StringNama;
    private String StringEmail;
    private String StringTelp;
    private String StringPass;
    private Customer customer = new Customer();
    private ImageButton editProfile;
    private DBHelper dbH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbH = new DBHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ImageButton btnBeranda = (ImageButton) findViewById(R.id.homeButton);
        ImageButton btnHistory = (ImageButton) findViewById(R.id.historyButton);
        ImageButton btnOrder = (ImageButton) findViewById(R.id.orderButton);
        ImageButton btnProfile = (ImageButton) findViewById(R.id.profileButton);

        TextView nama = (TextView) findViewById(R.id.edit_nama);
        TextView email = (TextView) findViewById(R.id.edit_email);
        EditText notelp = (EditText) findViewById(R.id.edit_nohp);
        EditText password = (EditText) findViewById(R.id.edit_password);

        ImageButton editProfile = (ImageButton) findViewById(R.id.ubahprofil);

        if (getIntent().getExtras() != null) {
            customer = getIntent().getParcelableExtra("customer");
            StringNama = customer.getNama();
            StringEmail = customer.getEmail();
            StringTelp = customer.getNoTelp();
            StringPass = customer.getPassword();
        }

        nama.setText(StringNama);
        email.setText(StringEmail);
        notelp.setText(StringTelp);
        password.setText(StringPass);

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
                goToProfil(customer);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHistory(customer);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean isEmpty = false;

                String mail = email.getText().toString().trim();
                String noHP = notelp.getText().toString().trim();
                String pass = password.getText().toString().trim();

                Customer cust;

                if (mail.isEmpty()) {
                    isEmpty = true;
                    email.setError("Field wajib diisi!");
                }

                if (noHP.isEmpty()) {
                    isEmpty = true;
                    notelp.setError("Field wajib diisi!");
                }

                if (pass.isEmpty()) {
                    isEmpty = true;
                    password.setError("Field wajib diisi!");
                }

                if (isEmpty == false) {
                    boolean cekUpdate = dbH.updateUser(pass,StringEmail,noHP);
                    if (cekUpdate) {
                        int id = dbH.getUserId(mail);
                        System.out.println("id = " + id);
                        Toast.makeText(EditProfileActivity.this, "Insert data berhasil", Toast.LENGTH_SHORT).show();
                        goToProfile(id, mail, StringNama, noHP, pass);
                    }
                } else {
                    Toast.makeText(EditProfileActivity.this, "Terdapat data kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void goToBeranda(Customer customer) {
        Intent intent = new Intent(this, BerandaActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToProfil(Customer customer) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToOrder(Customer customer) {
        Intent intent = new Intent(this, CreateOrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToHistory(Customer customer){
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToProfile(int id, String email, String name, String noHP, String pass) {
        Customer customer = new Customer(id, email, name, noHP, pass);
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }
}


