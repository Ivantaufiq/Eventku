package com.example.tbtekber.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tbtekber.HomeActivity;
import com.example.tbtekber.PendaftaranEvent.FreeEventActivity;
import com.example.tbtekber.PendaftaranEvent.PremiumActivity;
import com.example.tbtekber.R;

public class PendaftaranEventActivity extends AppCompatActivity {
    LinearLayout btnfree, btnpremium;
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_daftar_event);

        btnfree = findViewById(R.id.btnfree);
        btnpremium = findViewById(R.id.btnpremium);
        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PendaftaranEventActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnpremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PendaftaranEventActivity.this, PremiumActivity.class);
                startActivity(intent);
            }
        });

        btnfree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PendaftaranEventActivity.this, FreeEventActivity.class);
                startActivity(intent);
            }
        });
    }
}
