package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                String name = txtName.getText().toString();
                String email = txtEmail.getText().toString();
                String noHP = txtNohp.getText().toString();
                String pass = txtPass.getText().toString();

                boolean cekInsert = db.insertUser(name, pass, email, noHP);
                if(cekInsert == true){
                    Toast.makeText(RegisterActivity.this, "Insert data berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Gagal Insert data", Toast.LENGTH_SHORT).show();
                }
                goToHome2();

            }
        });
    }

    public void goToHome2(){
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);
    }
}