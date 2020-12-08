package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.javaapplication.DBController.DBHelper;
import com.example.javaapplication.Model.Customer.Customer;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtNama;
    private TextView txtEmail;
    private TextView txtNohp;
    private DBHelper db;
    private Customer customer = new Customer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton btnBeranda = (ImageButton) findViewById(R.id.homeButton);
        ImageButton btnHistory = (ImageButton) findViewById(R.id.historyButton);
        ImageButton btnOrder = (ImageButton) findViewById(R.id.orderButton);
        ImageButton btnProfile = (ImageButton) findViewById(R.id.profileButton);
        ImageButton btnChangeProfile = (ImageButton) findViewById(R.id.ubahprofil);
        ImageButton btnLogOut = (ImageButton) findViewById(R.id.logout);

        String profileNama = null;
        String profileEmail = null;
        String profileNohp = null;

        TextView showNama = (TextView) findViewById(R.id.profile_name);
        TextView showEmail = (TextView) findViewById(R.id.profile_email);
        TextView showNohp = (TextView) findViewById(R.id.profile_nohp);


        if (getIntent().getExtras() != null) {
            customer = getIntent().getParcelableExtra("customer");
            profileNama = customer.getNama();
            profileEmail = customer.getEmail();
            profileNohp = customer.getNoTelp();
        }

        showNama.setText(profileNama);
        showEmail.setText(profileEmail);
        showNohp.setText(profileNohp);

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

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });

        btnChangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToChangeProfile(customer);
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

    public void logOut(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToChangeProfile(Customer customer){
        Intent intent = new Intent(this, EditProfileActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }
}