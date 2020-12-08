package com.example.javaapplication.VendorView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaapplication.CreateOrderActivity;
import com.example.javaapplication.Model.Customer.Order;
import com.example.javaapplication.OrderAdapter;
import com.example.javaapplication.R;

import java.util.List;

public class OrderAdapterVendor extends RecyclerView.Adapter<OrderAdapterVendor.OrderViewHolder> {

    private List<Order> listOrder;
    private OnItemClickListener vendorListener;

    public interface OnItemClickListener {
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        vendorListener = listener;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView invoice;
        public TextView date;
        public TextView total;
        public TextView status;

        public OrderViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);

            invoice = itemView.findViewById(R.id.noInvoice);
            date = itemView.findViewById(R.id.tanggal);
            total = itemView.findViewById(R.id.biaya);
            status = itemView.findViewById(R.id.status);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public OrderAdapterVendor(List<Order> orders) {
        listOrder = orders;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_invoice_card_view, parent, false);
        OrderViewHolder holder = new OrderViewHolder(v, vendorListener);
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
