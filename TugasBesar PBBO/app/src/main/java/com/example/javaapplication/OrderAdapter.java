package com.example.javaapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaapplication.Model.Customer.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<Order> listOrder;

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView invoice;
        public TextView date;
        public TextView total;
        public TextView status;

        public OrderViewHolder(View itemView) {
            super(itemView);

            invoice = itemView.findViewById(R.id.noInvoice);
            date = itemView.findViewById(R.id.tanggal);
            total = itemView.findViewById(R.id.biaya);
            status = itemView.findViewById(R.id.status);
        }
    }

    public OrderAdapter(List<Order> orders) {
        listOrder = orders;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_invoice_card_view, parent, false);
        OrderViewHolder holder = new OrderViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        Order order = listOrder.get(position);
        String total = String.valueOf(order.getTotalPrice());
        String id = String.valueOf(order.getIdOrder());

        holder.invoice.setText("No Invoice : 000000"+ id);
        holder.date.setText(order.getTanggal());
        holder.status.setText("Status :" + order.getStatus());
        holder.total.setText("Total Biaya : Rp" + total);
    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }
}
