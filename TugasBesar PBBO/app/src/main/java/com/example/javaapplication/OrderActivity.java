package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class OrderActivity extends AppCompatActivity {

    private ImageButton btnBeranda = (ImageButton) findViewById(R.id.homeButton);
    private ImageButton btnHistory = (ImageButton) findViewById(R.id.historyButton);
    private ImageButton btnOrder = (ImageButton) findViewById(R.id.orderButton);
    private ImageButton btnProfile = (ImageButton) findViewById(R.id.profileButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        InvoiceCardView fragment = new InvoiceCardView();
        fragmentTransaction.add(R.id.fragment_invoice, fragment);
        fragmentTransaction.commit();

        btnBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBeranda();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToOrder();
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

    public void goToBeranda(){
        Intent intent = new Intent(this, BerandaActivity.class);
        startActivity(intent);
    }

    public void goToOrder(){
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

//    public void goToHistory(){
//        Intent intent = new Intent(this, OrderActivity.class);
//        startActivity(intent);
//    }

//    public void goToProfil(){
//        Intent intent = new Intent(this, Pr.class);
//        startActivity(intent);
//    }

}