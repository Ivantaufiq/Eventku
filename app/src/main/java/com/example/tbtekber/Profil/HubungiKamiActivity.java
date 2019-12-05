package com.example.tbtekber.Profil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tbtekber.ProfilActivity;
import com.example.tbtekber.R;


public class HubungiKamiActivity extends AppCompatActivity {
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi_kami);

        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HubungiKamiActivity.this, ProfilActivity.class);
                startActivity(intent);
            }
        });
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
