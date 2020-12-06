package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }

//    public void showNama(Customer cust){
//
//        customer = cust;
//        Intent intent = new Intent (this, ProfileActivity.class);
//    }
}