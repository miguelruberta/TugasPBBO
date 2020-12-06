package com.example.javaapplication.Model.SalesDepartment;

import com.example.javaapplication.Model.Customer.Customer;

public class CustomerPayment {
    private Customer customer;
    private String id;
    private SalesInvoice invoice;
    private int jumlah;
    private String method;
    public SalesInvoice m_SalesInvoice;

    public CustomerPayment(){

    }

    public void finalize() throws Throwable {

    }
}
