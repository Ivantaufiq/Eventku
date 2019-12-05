package com.example.tbtekber.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tbtekber.Entitas.Account;

public class AccountDB extends SQLiteOpenHelper {

    //tabel user
    private static String dbName = "eventku.db";
    private static String tableName = "account";
    private static String idColumn = "id";
    private static String namaColumn = "nama";
    private static String alamatColumn = "alamat";
    private static String passwordColumn = "password";
    private static String fotoColumn = "foto";
    private static String emailColumn = "email";

    //tabel pendaftaran event
    private static String tableEvent = "pendaftaran_event";
    private static String idEvent = "id_event";
    private static String gambarEvent = "gambar_event";
    private static String namaEvent = "nama_event";
    private static String lokasiEvent = "lokasi";
    private static String tglEvent = "tanggal_event";
    private static String deskripsiEvent = "deskripsi";

    private static final String CREATE_TABLE_EVENT = " create table " + tableEvent + "(" +
            idEvent + " integer primary key autoincrement, " +
            namaEvent + " text," + tglEvent + " date, " + lokasiEvent + " text," +
            deskripsiEvent + " text, " + gambarEvent + " blob " +
            ")";

    private static final String CREATE_TABLE_USER = " create table " + tableName + "(" +
            idColumn + " integer primary key autoincrement, " +
            emailColumn + " text not null, " +
            passwordColumn + " text not null, " +
            fotoColumn + " blob, " +
            namaColumn + " text, " +
            alamatColumn + " text " +
            ")";

    public AccountDB(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_EVENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + tableEvent);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + tableName);
        onCreate(sqLiteDatabase);
    }

    public boolean create(Account account){
        boolean result;
        result = true;
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(passwordColumn, account.getPassword());
            contentValues.put(emailColumn, account.getEmail());
            result = sqLiteDatabase.insert(tableName, null, contentValues) > 0;
        }catch (Exception e){
            result = false;
        }
        return result;
    }

    public Account login(String email, String password){
        Account account = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(" select * from " + tableName + " where email = ? and password = ?",
                    new String[]{email, password});
            if (cursor.moveToFirst()){
                account = new Account();
                account.setId(cursor.getInt(0));
                account.setEmail(cursor.getString(1));
                account.setPassword(cursor.getString(2));
            }
        }catch (Exception e){
            account = null;
        }
        return account;
    }

    public Account checkEmail(String email){
        Account account = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(" select * from " + tableName + " where email = ? ",
                    new String[]{email});
            if (cursor.moveToFirst()){
                account = new Account();
                account.setId(cursor.getInt(0));
                account.setEmail(cursor.getString(1));
                account.setPassword(cursor.getString(2));
            }
        }catch (Exception e){
            account = null;
        }
        return account;
    }
}


