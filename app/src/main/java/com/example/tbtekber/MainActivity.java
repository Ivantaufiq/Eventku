package com.example.tbtekber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tbtekber.Database.AccountDB;
import com.example.tbtekber.Entitas.Account;

public class MainActivity extends AppCompatActivity {
    Button btndaftar, btnmasuk;
    EditText editTextEmail, editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = (EditText) findViewById(R.id.inputemail);
        editTextPass = (EditText) findViewById(R.id.inputpassword);
        btndaftar = (Button) findViewById(R.id.btndaftar);
        btnmasuk = (Button) findViewById(R.id.btnmasuk);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnmasuk_onClick(view);
            }
        });

    }

    private void btnmasuk_onClick(View view) {
        AccountDB accountDB = new AccountDB(getApplicationContext());
        String email = editTextEmail.getText().toString();
        String password = editTextPass.getText().toString();
        Account account = accountDB.login(email, password);
        if (account == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle(R.string.error);
            builder.setMessage(R.string.invalid_account);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        } else {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("account", account);
            startActivity(intent);
        }
    }
}
