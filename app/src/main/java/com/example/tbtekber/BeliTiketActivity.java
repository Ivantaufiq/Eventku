package com.example.tbtekber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tbtekber.DaftarEvent.Event5Activity;

public class BeliTiketActivity extends AppCompatActivity {
    private int naik = 0;
    Button countup, countdown, bayar;
    TextView hasil;
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_tiket);

        countup = findViewById(R.id.countup);
        countdown = findViewById(R.id.countdown);
        hasil = findViewById(R.id.hasil);
        bayar = findViewById(R.id.bayar);
        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeliTiketActivity.this, Event5Activity.class);
                startActivity(intent);
            }
        });

        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeliTiketActivity.this, BayarActivity.class);
                startActivity(intent);
            }
        });

        countup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naik ++;
                hasil.setText(Integer.toString(naik));
            }
        });

        countdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naik --;
                hasil.setText(Integer.toString(naik));
            }
        });
    }
}
