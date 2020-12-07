package com.example.javaapplication.DBController;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.javaapplication.Model.Customer.Customer;

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


    public boolean addOrder(String designFile, int jumlahOrder, String tipeKain, String warna, int s, int m, int l, int xl, String sablon, Date tanggal, int total, String status, Customer cust){
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
        contentValues.put("idCust", cust.getId());

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
}

