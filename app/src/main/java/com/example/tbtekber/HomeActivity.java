package com.example.tbtekber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    public void buttonWishlist(View view) {
        Intent b = new Intent(HomeActivity.this,MainActivity.class);
        startActivity(b);
    }

    public void buttonProfil(View view) {
        Intent c = new Intent(HomeActivity.this,KonsumenActivity.class);
        startActivity(c);
    }
}