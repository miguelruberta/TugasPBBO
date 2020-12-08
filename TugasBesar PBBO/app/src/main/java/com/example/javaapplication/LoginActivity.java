package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javaapplication.DBController.DBHelper;
import com.example.javaapplication.Model.Customer.Customer;

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private EditText txtWarning;
    private EditText txtWarning2;
    private EditText txtEmail;
    private EditText txtPassword;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);
        txtWarning = (EditText) findViewById(R.id.input_password);
        txtWarning2 = (EditText) findViewById(R.id.input_email);
        txtEmail = (EditText) findViewById(R.id.input_email);
        txtPassword = (EditText) findViewById(R.id.input_password);
//        txtName = (EditText) findViewById(R.id.input_nama);
        login = (Button) findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                String name = txtName.getText().toString();
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                validasi(txtWarning,txtWarning2);
                boolean cekLogin = db.Authenticate(email, password);
                Log.d("ADebugTag", "Value: " + (cekLogin));
                if (cekLogin == true) {
                    Toast.makeText(LoginActivity.this, "Selamat datang " + email + "!", Toast.LENGTH_SHORT).show();
                    Customer cust = db.getUserObject(email);
                    goToBeranda(cust);
                    Toast.makeText(LoginActivity.this, "Selamat datang " + "!", Toast.LENGTH_SHORT).show();
//                    goToHome();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                    //goToHome();
                }
            }
        });
    }

    public void goToBeranda(Customer cust) {
        Customer customer = cust;
        Intent intent = new Intent (this, BerandaActivity.class); //BerandaActivity
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToOrder(Customer customer){
        Intent intent = new Intent(this, CreateOrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void validasi(EditText a, EditText b) {

        if (txtWarning.getText().toString().length() == 0 & txtWarning2.getText().toString().length() == 0) {
            txtWarning.setError("Field Password tidak boleh kosong!");
            txtWarning2.setError("Field Email tidak boleh kosong!");
        } else if (txtWarning.getText().toString().length() == 0) {
            Toast.makeText(LoginActivity.this, "Password wajib diisi", Toast.LENGTH_SHORT).show();
        } else if (txtWarning2.getText().toString().length() == 0) {
            Toast.makeText(LoginActivity.this, " Email wajib diisi", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();
        }
    }

}