package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.javaapplication.Model.Customer;

public class OrderActivity extends AppCompatActivity {

    private Customer customer = new Customer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ImageButton btnBeranda = (ImageButton) findViewById(R.id.homeButton);
        ImageButton btnHistory = (ImageButton) findViewById(R.id.historyButton);
        ImageButton btnOrder = (ImageButton) findViewById(R.id.orderButton);
        ImageButton btnProfile = (ImageButton) findViewById(R.id.profileButton);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        InvoiceCardView fragment = new InvoiceCardView();
        fragmentTransaction.add(R.id.fragment_invoice, fragment);
        fragmentTransaction.commit();

        if(getIntent().getExtras() != null) {
            customer = getIntent().getParcelableExtra("customer");
        }

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
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //frame_container is your layout name in xml file
        transaction.replace(R.id.fragment_invoice, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void goToBeranda(Customer customer){
        Intent intent = new Intent(this, BerandaActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToOrder(Customer customer){
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

//    public void goToHistory(Customer customer){
//        Intent intent = new Intent(this, HistoryActivity.class);
//        intent.putExtra("customer", customer);
//        startActivity(intent);
//    }

//    public void goToProfil(Customer customer){
//        Intent intent = new Intent(this, ProfileActivity.class);
//        intent.putExtra("customer", customer);
//        startActivity(intent);
//    }

}