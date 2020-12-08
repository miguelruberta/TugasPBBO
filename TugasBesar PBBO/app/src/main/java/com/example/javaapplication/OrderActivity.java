package com.example.javaapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.javaapplication.DBController.DBHelperOrder;
import com.example.javaapplication.Model.Customer.Customer;
import com.example.javaapplication.Model.Customer.Order;
import com.example.javaapplication.Model.Vendor.Kaos;

import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private DBHelperOrder dbOrder = new DBHelperOrder(this);
    private Customer customer = new Customer();
    private Order order = new Order();
    private Kaos kaos = new Kaos();

    private RecyclerView viewOrder;
    private RecyclerView.Adapter orderAdapter;
    private RecyclerView.LayoutManager orderManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        if(getIntent().getExtras() != null) {
            customer = getIntent().getParcelableExtra("customer");
        }

        ImageButton btnBeranda = (ImageButton) findViewById(R.id.homeButton);
        ImageButton btnHistory = (ImageButton) findViewById(R.id.historyButton);
        ImageButton btnOrder = (ImageButton) findViewById(R.id.orderButton);
        ImageButton btnProfile = (ImageButton) findViewById(R.id.profileButton);

        List<Order> order = dbOrder.getOrderByCust(customer);
        System.out.println("jumlah array = " + order.size());
        if (order.size() > 0) {
            viewOrder = findViewById(R.id.recyclerViewListPesanan);
            orderManager = new LinearLayoutManager(this);
            orderAdapter = new OrderAdapter(order);
            viewOrder.setLayoutManager(orderManager);
            viewOrder.setAdapter(orderAdapter);
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

//    private void loadFragment(Fragment fragment) {
//        // load fragment
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        //frame_container is your layout name in xml file
//        transaction.replace(R.id.fragment_invoice, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }

//    public RecyclerView.Adapter<listOrderAdapter.ListViewHolder> listOrderAdapter(List<Order> list) {
//        for (Order order : list) {
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            InvoiceCardView fragment = new InvoiceCardView();
//            fragmentTransaction.add(R.id.fragment_invoice, fragment);
//
//            invoice.setText("0000"+order.getIdOrder());
//            date.setText(order.getTanggal());
//            total.setText(order.getTotalPrice());
//            status.setText(order.getStatus());
//
//            fragmentTransaction.commit();
//        }
//    }

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
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }

    public void goToHistory(Customer customer){
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("customer", customer);
        startActivity(intent);
    }
}