package com.example.tbtekber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tbtekber.Profil.HubungiKamiActivity;
import com.example.tbtekber.Profil.UbahEmail;
import com.example.tbtekber.Profil.UbahPassword;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }

    public void hubungikami(View view) {
        Intent intent = new Intent(ProfilActivity.this, HubungiKamiActivity.class);
        startActivity(intent);
    }

    public void ubahemail(View view) {
        Intent intent = new Intent(ProfilActivity.this, UbahEmail.class);
        startActivity(intent);
    }

    public void ubahpassword(View view) {
        Intent intent = new Intent(ProfilActivity.this, UbahPassword.class);
        startActivity(intent);
    }
}
