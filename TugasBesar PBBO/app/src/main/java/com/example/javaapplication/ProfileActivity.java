package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.javaapplication.DBController.DBHelper;
import com.example.javaapplication.Model.Customer;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtNama;
    private DBHelper db;
    private Customer customer = new Customer();

    @Override
    protected void onCreate(Bundle savedInstanceState)

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView showNama = (TextView)findViewById(R.id.nama);
        showNama.setText("Kevin");
    }

    public void showNama(Customer customer){
        Intent intent = new Intent (this, BerandaActivity.class);
    }
}