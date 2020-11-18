package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BerandaActivity extends AppCompatActivity {

    private ImageButton btnBeranda = (ImageButton) findViewById(R.id.homeButton);
    private ImageButton btnHistory = (ImageButton) findViewById(R.id.historyButton);
    private ImageButton btnOrder = (ImageButton) findViewById(R.id.orderButton);
    private ImageButton btnProfile = (ImageButton) findViewById(R.id.profileButton);
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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