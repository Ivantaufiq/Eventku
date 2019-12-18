package com.example.tbtekber.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tbtekber.Home.CariEventActivity;
import com.example.tbtekber.DaftarEvent.Event5Activity;
import com.example.tbtekber.DaftarEvent.Event6Activity;
import com.example.tbtekber.Home.PendaftaranEventActivity;
import com.example.tbtekber.R;

public class Home2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
    }

    public void buttonSearch(View view) {
        Intent a = new Intent(Home2.this, CariEventActivity.class);
        startActivity(a);
    }

    public void buttonPendaftaran(View view) {
        Intent b = new Intent(Home2.this, PendaftaranEventActivity.class);
        startActivity(b);
    }

    public void buttonProfil(View view) {
        Intent c = new Intent(Home2.this, Profil2.class);
        startActivity(c);
    }

    public void event5(View view) {
        Intent intent = new Intent(Home2.this, Event5Activity.class);
        startActivity(intent);
    }

    public void event6(View view) {
        Intent intent = new Intent(Home2.this, Event6Activity.class);
        startActivity(intent);
    }
}
