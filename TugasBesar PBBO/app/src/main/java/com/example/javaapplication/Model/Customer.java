package com.example.javaapplication.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable{
    private String email;
    private int id;
    private String nama;
    private String noTelp;
    private String password;

    public Customer() {
    }

    public Customer(int id, String email, String nama, String telp, String pwd) {
        this.id = id;
        this.email = email;
        this.nama = nama;
        this.noTelp = telp;
        this.password = pwd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.noTelp);
    }

    protected Customer(Parcel in) {
        this.id = in.readInt();
        this.nama = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.noTelp = in.readString();
    }

    public static final Parcelable.Creator<Customer> CREATOR = new Parcelable.Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel source) {
            return new Customer(source);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };
}
