package com.example.tbtekber.Profil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tbtekber.ProfilActivity;
import com.example.tbtekber.R;

public class UbahPassword extends AppCompatActivity {
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_password);

        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UbahPassword.this, ProfilActivity.class);
                startActivity(intent);
            }
        });
    }
}
