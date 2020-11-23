package com.example.javaapplication.DBController;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Brolon.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT NOT NULL, " +
                "password TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "nohp TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
    }

    public boolean Authenticate(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email = ?", new String[]{email});

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

    public boolean insertUser (String name, String password, String email, String nohp){
        SQLiteDatabase db = this.getWritableDatabase();
        password = md5(password);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("nohp", nohp);
        long result = db.insert("user", null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean updateUser (String password, String email, String nohp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("nohp", nohp);
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email = ?", new String[]{email});

        if(cursor.getCount() > 0){
            long result = db.update("user", contentValues, "email=?", new String[]{email});
            if(result == -1){
                return false;
            }else{
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean deleteUser (String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE name = ?", new String[]{name});

        if(cursor.getCount() > 0){
            long result = db.delete("user", "name=?", new String[]{name});
            if(result == -1){
                return false;
            }else{
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean checkUser (String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE TRIM(email) = '"+email.trim()+"'", null);

        //System.out.println(cursor.getCount());
        if (cursor.moveToFirst()) {
            if(cursor.getCount() > 0){
                return true;
            }
        }
        return false;
    }

    public int getUserId (String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM user WHERE TRIM(email) = '"+email.trim()+"'", null);
        int userId = 0;

        //System.out.println(cursor.getCount());
        if (cursor.moveToFirst()) {
            do {
                userId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            } while (cursor.moveToNext());
//            if(cursor.getCount() > 0){
//                int userId = Integer.parseInt(cursor.toString());
//                return userId;
//            }
        }
//        System.out.println("id " + userId);
        return userId;
    }

    public Cursor getData (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user", null);

        return cursor;
    }
}