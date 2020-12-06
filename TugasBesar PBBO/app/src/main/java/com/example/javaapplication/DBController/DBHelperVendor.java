package com.example.javaapplication.DBController;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DBHelperVendor extends SQLiteOpenHelper {

    public DBHelperVendor(Context context) { super(context, "Brolon.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE vendor(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT NOT NULL, " +
                "password TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "alamat TEXT NOT NULL, " +
                "jam_kerja TEXT NOT NULL, " +
                "nohp TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS vendor");
    }

    public boolean AuthenticateVendor(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM vendor WHERE email = ?", new String[]{email});

//        Log.d("ADebugTag X", "Value: " + (x));
//        Cursor cursor2 = db.rawQuery("user",
//                new String[]{"password"},
//                "password" + "=?",
//                new String[]{password}, null, null, null);

        if (cursor.getCount() > 0) {
            String y = md5(password);
            cursor.moveToFirst();
            Log.d("ADebugTag X", "Value: " + (cursor.getString(2)));
//            Log.d("ADebugTag X", "Value: " + (x));
//            Log.d("ADebugTag Y", "Value: " + (y));
            if (y.equalsIgnoreCase(cursor.getString(2))) {
                cursor.close();
                return true;
            } else {
                cursor.close();
                return false;
            }
        } else {
            cursor.close();
            return false;

        }
    }

    public static final String md5(final String p){
        final String md5 = "md5";
        try{
            MessageDigest digest = java.security.MessageDigest.getInstance(md5);
            digest.update(p.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuilder hexString = new StringBuilder();

            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return "";
    }
}
