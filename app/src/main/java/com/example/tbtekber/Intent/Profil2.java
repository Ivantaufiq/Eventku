package com.example.tbtekber.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tbtekber.Profil.HubungiKamiActivity;
import com.example.tbtekber.Profil.UbahEmail;
import com.example.tbtekber.Profil.UbahPassword;
import com.example.tbtekber.ProfilActivity;
import com.example.tbtekber.R;

public class Profil2 extends AppCompatActivity {
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil2);

        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profil2.this, Home2.class);
                startActivity(intent);
            }
        });
    }

    public void hubungikami(View view) {
        Intent intent = new Intent(Profil2.this, HubungiKamiActivity.class);
        startActivity(intent);
    }

    public void ubahemail(View view) {
        Intent intent = new Intent(Profil2.this, UbahEmail.class);
        startActivity(intent);
    }

    public void ubahpassword(View view) {
        Intent intent = new Intent(Profil2.this, UbahPassword.class);
        startActivity(intent);
    }
}
