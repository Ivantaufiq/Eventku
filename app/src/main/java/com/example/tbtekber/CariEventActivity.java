package com.example.tbtekber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tbtekber.DaftarEvent.Event1Activity;
import com.example.tbtekber.DaftarEvent.Event2Activity;
import com.example.tbtekber.DaftarEvent.Event3Activity;
import com.example.tbtekber.DaftarEvent.Event4Activity;
import com.example.tbtekber.DaftarEvent.Event5Activity;
import com.example.tbtekber.DaftarEvent.Event6Activity;

public class CariEventActivity extends AppCompatActivity {
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_event);

        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CariEventActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void event1(View view) {
        Intent intent = new Intent(CariEventActivity.this, Event1Activity.class);
        startActivity(intent);
    }

    public void event2(View view) {
        Intent intent = new Intent(CariEventActivity.this, Event2Activity.class);
        startActivity(intent);
    }

    public void event3(View view) {
        Intent intent = new Intent(CariEventActivity.this, Event3Activity.class);
        startActivity(intent);
    }

    public void event4(View view) {
        Intent intent = new Intent(CariEventActivity.this, Event4Activity.class);
        startActivity(intent);
    }

    public void event5(View view) {
        Intent intent = new Intent(CariEventActivity.this, Event5Activity.class);
        startActivity(intent);
    }

    public void event6(View view) {
        Intent intent = new Intent(CariEventActivity.this, Event6Activity.class);
        startActivity(intent);
    }
}
