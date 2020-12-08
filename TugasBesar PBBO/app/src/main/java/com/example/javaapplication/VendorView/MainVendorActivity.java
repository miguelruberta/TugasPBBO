package com.example.javaapplication.VendorView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.javaapplication.DBController.DBHelperOrder;
import com.example.javaapplication.DBController.DBHelperVendor;
import com.example.javaapplication.HomeActivity;
import com.example.javaapplication.MainActivity;
import com.example.javaapplication.Model.Customer.Order;
import com.example.javaapplication.Model.Vendor.Kaos;
import com.example.javaapplication.OrderAdapter;
import com.example.javaapplication.R;

import java.util.List;

public class MainVendorActivity extends AppCompatActivity {

    private DBHelperVendor dbVendor = new DBHelperVendor(this);
    private Order order = new Order();
    private Kaos kaos = new Kaos();

    private RecyclerView viewOrder;
    private OrderAdapterVendor orderAdapterVendor;
    private RecyclerView.LayoutManager orderManager;

    private ImageButton btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vendor);

        List<Order> orders = dbVendor.getAllOrder();
        System.out.println(orders.size());
        if (orders.size() > 0) {
            viewOrder = findViewById(R.id.recyclerViewListPesanan);
            orderManager = new LinearLayoutManager(this);
            orderAdapterVendor = new OrderAdapterVendor(orders);
            viewOrder.setLayoutManager(orderManager);
            viewOrder.setAdapter(orderAdapterVendor);

            orderAdapterVendor.setOnItemClickListener(new OrderAdapterVendor.OnItemClickListener() {
                @Override
                public void OnItemClick(int position) {
                    Order order = orders.get(position);
                    goToChangeOrder(order);
                }
            });
        }

        btnLogout = (ImageButton) findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
    }

    public void goToChangeOrder(Order order) {
        Intent intent = new Intent(this, ChangeOrderActivity.class);
        intent.putExtra("ID_ORDER", order.getIdOrder());
        startActivity(intent);
    }

    public void goToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}