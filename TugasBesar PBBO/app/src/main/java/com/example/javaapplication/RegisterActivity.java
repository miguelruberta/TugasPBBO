package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javaapplication.DBController.DBHelper;
import com.example.javaapplication.Model.Customer.Customer;

public class RegisterActivity extends AppCompatActivity {

    private Button register;
    private EditText txtName;
    private EditText txtEmail;
    private EditText txtNohp;
    private EditText txtPass;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (Button) findViewById(R.id.btn_register);
        txtName = (EditText) findViewById(R.id.input_nama);
        txtPass = (EditText) findViewById(R.id.input_password);
        txtEmail = (EditText) findViewById(R.id.input_email);
        txtNohp = (EditText) findViewById(R.id.input_nohp);
        db = new DBHelper(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean isEmpty = false;

                String name = txtName.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                String noHP = txtNohp.getText().toString().trim();
                String pass = txtPass.getText().toString().trim();

                Customer cust;

                if (name.isEmpty()) {
                    isEmpty = true;
                    txtName.setError("Field wajib diisi!");
                }

                if (email.isEmpty()) {
                    isEmpty = true;
                    txtEmail.setError("Field wajib diisi!");
                }

                if (noHP.isEmpty()) {
                    isEmpty = true;
                    txtNohp.setError("Field wajib diisi!");
                }

                if (pass.isEmpty()) {
                    isEmpty = true;
                    txtPass.setError("Field wajib diisi!");
                }

                if (isEmpty == false) {
                    boolean checkAva = db.checkUser(email);
                    if (checkAva == true) {     //check jika email sudah terdaftar atau belum
                        Toast.makeText(RegisterActivity.this, "Email Telah Terdaftar", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean cekInsert = db.insertUser(name, pass, email, noHP);
                        //System.out.println(cekInsert);
                        if (cekInsert == true) {
                            int id = db.getUserId(email);
                            System.out.println("id = " + id);
                            Toast.makeText(RegisterActivity.this, "Insert data berhasil", Toast.LENGTH_SHORT).show();
                            goToBeranda(id, email, name, noHP, pass);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Gagal Insert data", Toast.LENGTH_SHORT).show();
                            goToHome();
                        }
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Terdapat data kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void goToHome(){
        Intent intent = new Intent (this, HomeActivity.class);
        startActivity(intent);
    }

    public void goToBeranda(int id, String email, String name, String noHP, String pass) {
        Customer customer = new Customer(id, email, name, noHP, pass);
        Intent intent = new Intent (this, BerandaActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }
}