package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button logined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        logined = (Button) findViewById(R.id.btn_login);
//        logined.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                goToMainScreen();
//
//            }
//        });
//
//    }
//        public void goToMainScreen(){
//            Intent intent = new Intent(this, LoginedActivity.class);
//            startActivity(intent);
//        }
    }
}