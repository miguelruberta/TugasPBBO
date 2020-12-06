package com.example.javaapplication.Model.SalesDepartment;

public class SalesDepartment {
    private String email;
    private String id;
    private SalesInvoice invoice;
    private String phoneNum;
    public SalesInvoice m_SalesInvoice;
    public VendorPayment m_VendorPayment;

    public SalesDepartment(){

    }

    public void finalize() throws Throwable {

    }
}
