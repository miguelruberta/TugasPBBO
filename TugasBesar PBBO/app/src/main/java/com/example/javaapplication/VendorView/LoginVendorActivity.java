package com.example.javaapplication.VendorView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.javaapplication.BerandaActivity;
import com.example.javaapplication.DBController.DBHelperVendor;
import com.example.javaapplication.LoginActivity;
import com.example.javaapplication.R;

public class LoginVendorActivity extends AppCompatActivity {

    DBHelperVendor db = new DBHelperVendor(this);

    EditText emailVendor;
    EditText passwordVendor;
    Button loginVendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_vendor);

        emailVendor = (EditText) findViewById(R.id.input_email_vendor);
        passwordVendor = (EditText) findViewById(R.id.input_password_vendor);

        loginVendor = (Button) findViewById(R.id.btn_login_vendor);
        loginVendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailVendor.getText().toString();
                String pwd = passwordVendor.getText().toString();

                if (validasi(email, pwd)) {
                    Toast.makeText(LoginVendorActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    goToHomeVendor();
                } else {
                    Toast.makeText(LoginVendorActivity.this, "Input Salah", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public boolean validasi(String email, String password) {
        if (email.equals("admin@admin.com") && password.equals("password123")) {
            return true;
        }
        return false;
    }

    public void goToHomeVendor() {
        Intent intent = new Intent (this, MainVendorActivity.class);
        startActivity(intent);
    }
}