package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    private ImageButton btnBeranda = (ImageButton) findViewById(R.id.homeButton);
    private ImageButton btnHistory = (ImageButton) findViewById(R.id.historyButton);
    private ImageButton btnOrder = (ImageButton) findViewById(R.id.orderButton);
    private ImageButton btnProfile = (ImageButton) findViewById(R.id.profileButton);
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnBeranda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_home);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView();
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView();
            }
        });
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}