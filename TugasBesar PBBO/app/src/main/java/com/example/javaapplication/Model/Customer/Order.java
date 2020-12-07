package com.example.javaapplication.Model.Customer;

import com.example.javaapplication.Model.Vendor.Kaos;
import com.example.javaapplication.Model.Vendor.Sablon;

import java.util.Date;

public class Order {
    private int idOrder;
    private int jumlahOrder;
    private Kaos kaos;
    private String sablon;
    private String tanggal;
    private int totalPrice;
    private String status;
    private Customer cust;
    public Order(){

    }

    public Order(int id, int jumlahOrder, Kaos kaos, String sablon, String tanggal, int totalPrice, String status, Customer cust){
        this.idOrder = id;
        this.jumlahOrder = jumlahOrder;
        this.kaos = kaos;
        this.sablon = sablon;
        this.tanggal = tanggal;
        this.totalPrice = totalPrice;
        this.status = status;
        this.cust = cust;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getJumlahOrder() {
        return jumlahOrder;
    }

    public void setJumlahOrder(int jumlahOrder) {
        this.jumlahOrder = jumlahOrder;
    }

    public Kaos getKaos() {
        return kaos;
    }

    public void setKaos(Kaos kaos) {
        this.kaos = kaos;
    }

    public String getSablon() {
        return sablon;
    }

    public void setSablon(String sablon) {
        this.sablon = sablon;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public void finalize() throws Throwable {

    }
}
