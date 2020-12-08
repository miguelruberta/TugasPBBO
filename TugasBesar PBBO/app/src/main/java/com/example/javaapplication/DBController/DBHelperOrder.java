package com.example.javaapplication.DBController;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.system.ErrnoException;
import android.util.Log;

import com.example.javaapplication.Model.Customer.Customer;
import com.example.javaapplication.Model.Customer.Order;
import com.example.javaapplication.Model.Vendor.Kaos;


public class DBHelperOrder extends SQLiteOpenHelper {

    public DBHelperOrder(Context context) { super(context, "Brolon.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pesanan(idOrder INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "designFile TEXT NOT NULL, " +
                "jumlahOrder INTEGER NOT NULL, " +
                "tipeKain TEXT NOT NULL, " +
                "warna TEXT NOT NULL, " +
                "KaosS INTEGER NOT NULL, " +
                "KaosM INTEGER NOT NULL, " +
                "KaosL INTEGER NOT NULL, " +
                "KaosXL INTEGER NOT NULL, " +
                "sablon TEXT NOT NULL, " +
                "tanggal TEXT NOT NULL, " +
                "totalPrice INTEGER NOT NULL, " +
                "status TEXT NOT NULL, " +
                "idCust INT NOT NULL, " +
                "FOREIGN KEY(idCust) REFERENCES user(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS pesanan");
    }

    public boolean addOrder(String designFile, int jumlahOrder, String tipeKain, String warna, int s, int m, int l, int xl, String sablon, String tanggal, int total, String status, int cust){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("designFile", designFile);
        contentValues.put("jumlahOrder", jumlahOrder);
        contentValues.put("tipeKain", tipeKain);
        contentValues.put("warna", warna);
        contentValues.put("KaosS", s);
        contentValues.put("KaosM", m);
        contentValues.put("KaosL", l);
        contentValues.put("KaosXL", xl);
        contentValues.put("sablon", sablon);
        contentValues.put("tanggal", String.valueOf(tanggal));
        contentValues.put("totalPrice", total);
        contentValues.put("status", status);
        contentValues.put("idCust", cust);

        long result = db.insert("pesanan", null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean editOrder(int id, String status){ //Untuk Vendor
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", status);
        Cursor cursor = db.rawQuery("SELECT * FROM pesanan WHERE idOrder = ?", new String[]{String.valueOf(id)});

        if(cursor.getCount() > 0){
            long result = db.update("pesanan", contentValues, "idOrder=?", new String[]{String.valueOf(id)});
            if(result == -1){
                return false;
            }else{
                return true;
            }
        } else {
            return false;
        }
    }

    public List<Order> getOrderByCust(Customer cust){
        SQLiteDatabase db = this.getWritableDatabase();
        int custId = cust.getId();
        Cursor cursor = db.rawQuery("SELECT * FROM pesanan WHERE idCust = ?", new String[]{String.valueOf(custId)});

        final int idOrderIndex = cursor.getColumnIndex("idOrder");
        final int designFileIndex = cursor.getColumnIndex("designFile");
        final int jumlahOrderIndex = cursor.getColumnIndex("jumlahOrder");
        final int tipeKainIndex = cursor.getColumnIndex("tipeKain");
        final int warnaIndex = cursor.getColumnIndex("warna");
        final int kaosSIndex = cursor.getColumnIndex("KaosS");
        final int kaosMIndex = cursor.getColumnIndex("KaosM");
        final int kaosLIndex = cursor.getColumnIndex("KaosL");
        final int kaosXLIndex = cursor.getColumnIndex("KaosXL");
        final int sablonIndex = cursor.getColumnIndex("sablon");
        final int tanggalIndex = cursor.getColumnIndex("tanggal");
        final int totalPriceIndex = cursor.getColumnIndex("totalPrice");
        final int statusIndex = cursor.getColumnIndex("status");
        final int idCustIndex = cursor.getColumnIndex("idCust");

        try{
            // If moveToFirst() returns false then cursor is empty
            if (!cursor.moveToFirst()) {
                return new ArrayList<>();
            }
            final List<Order> arrOrder = new ArrayList<>();
            do {
                // Read the values of a row in the table using the indexes acquired above
                final int id = cursor.getInt(idOrderIndex);
                final String design = cursor.getString(designFileIndex);
                final int jumlah = cursor.getInt(jumlahOrderIndex);
                final String tipeKain = cursor.getString(tipeKainIndex);
                final String warna = cursor.getString(warnaIndex);
                final int S = cursor.getInt(kaosSIndex);
                final int M = cursor.getInt(kaosMIndex);
                final int L = cursor.getInt(kaosLIndex);
                final int XL = cursor.getInt(kaosXLIndex);
                final String sablon = cursor.getString(sablonIndex);
                final String tanggal = cursor.getString(tanggalIndex);
                final int totalPrice = cursor.getInt(totalPriceIndex);
                final String status = cursor.getString(statusIndex);
                final int idCust = cursor.getInt(idCustIndex);

                Kaos kaos = new Kaos(tipeKain, warna);
                Order order = new Order(id, jumlah, kaos, sablon, tanggal, totalPrice, status, cust);

                arrOrder.add(order);
            } while (cursor.moveToNext());
            return arrOrder;

        } finally {
            cursor.close();
            db.close();
        }

        //Kaos kaos = new Kaos();
        //Order order = new Order()
    }
}

