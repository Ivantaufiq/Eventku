package com.example.tbtekber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tbtekber.DaftarEvent.Event5Activity;
import com.example.tbtekber.DaftarEvent.Event6Activity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void buttonSearch(View view) {
        Intent a = new Intent(HomeActivity.this,CariEventActivity.class);
        startActivity(a);
    }

    public void buttonPendaftaran(View view) {
        Intent b = new Intent(HomeActivity.this,PilihDaftarEvent.class);
        startActivity(b);
    }

    public void buttonProfil(View view) {
        Intent c = new Intent(HomeActivity.this,ProfilActivity.class);
        startActivity(c);
    }

    public void event5(View view) {
        Intent intent = new Intent(HomeActivity.this, Event5Activity.class);
        startActivity(intent);
    }

    public void event6(View view) {
        Intent intent = new Intent(HomeActivity.this, Event6Activity.class);
        startActivity(intent);
    }
}
