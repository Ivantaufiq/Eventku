package com.example.tbtekber.Profil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.tbtekber.R;

import java.net.URI;

public class HubungiKamiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi_kami);
    }

    public void instagram(View view) {
        Intent link1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"));
        startActivity(link1);
    }

    public void facebook(View view) {
        Intent link1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/eventku.eventku.7"));
        startActivity(link1);
    }

    public void kontak(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+62895701992393"));
        startActivity(intent);
    }
}
