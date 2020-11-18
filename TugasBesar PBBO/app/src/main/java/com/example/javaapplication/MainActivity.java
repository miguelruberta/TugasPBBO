package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button_login;
    private Button button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

//        btn_login = (Button) findViewById(R.id.btn_login);
//        btn_login.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick (View v){
//                goToHome();
//            }
//        });

        button_login = (Button) findViewById(R.id.btn_login);
        button_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                goToLogin();
            }
        });

        button_register = (Button) findViewById(R.id.btn_register);
        button_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                goToRegister();
            }
        });
    }

    public void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToRegister() {
        Intent intent = new Intent (this, RegisterActivity.class);
        startActivity(intent);
    }
}