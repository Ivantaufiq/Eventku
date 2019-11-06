package com.example.tbtekber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PembayaranActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        text = findViewById(R.id.nmr_bank);
    }

    public void buttonCopy1(View view) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("ViewText", text.getText().toString());
        clipboard.setPrimaryClip(clip);

        clip.getDescription();

        Toast.makeText(PembayaranActivity.this, "Copied", Toast.LENGTH_SHORT).show();
    }
}
