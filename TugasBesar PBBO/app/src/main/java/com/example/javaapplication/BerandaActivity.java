package com.example.javaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaapplication.Model.Customer.Customer;


public class BerandaActivity extends AppCompatActivity {

    private Customer customer = new Customer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        ImageButton btnBeranda = (ImageButton) findViewById(R.id.homeButton);
        ImageButton btnHistory = (ImageButton) findViewById(R.id.historyButton);
        ImageButton btnOrder = (ImageButton) findViewById(R.id.orderButton);
        ImageButton btnProfile = (ImageButton) findViewById(R.id.profileButton);

        if(getIntent().getExtras() != null) {
            customer = getIntent().getParcelableExtra("customer");
        }

        //System.out.println(customer.getNama());

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
        Intent intent = new Intent(this, CreateOrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToHistory(Customer customer){
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }
}