package com.example.javaapplication.Model.Customer;

import com.example.javaapplication.Model.Vendor.Kaos;
import com.example.javaapplication.Model.Vendor.Sablon;

import java.util.Date;

public class Order {
    private String designFile;
    private int idOrder;
    private int jumlahOrder;
    private Kaos kaos;
    private Sablon sablon;
    private Date tanggal;
    private int totalPrice;
    public Customer m_Customer;

    public Order(){

    }

    public void finalize() throws Throwable {

    }
}
