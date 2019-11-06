package com.example.tbtekber.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tbtekber.Entitas.Account;

public class AccountDB extends SQLiteOpenHelper {

    private static String dbName = "eventku.db";
    private static String tableName = "account";
    private static String idColumn = "id";
    private static String namaColumn = "nama";
    private static String passwordColumn = "password";
    private static String emailColumn = "email";

    public AccountDB(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" create table " + tableName + "(" +
                idColumn + " integer primary key autoincrement, " +
                emailColumn + " text not null, " +
                passwordColumn + " text not null " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
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


