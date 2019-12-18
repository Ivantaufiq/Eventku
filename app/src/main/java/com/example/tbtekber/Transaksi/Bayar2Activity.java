package com.example.tbtekber.Transaksi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tbtekber.Intent.Home4;
import com.example.tbtekber.PremiumActivity;
import com.example.tbtekber.R;

public class Bayar2Activity extends AppCompatActivity {
    Spinner spinner;
    ImageView arrow,imageview;
    Button kirim,gantifoto;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar2);
        arrow = findViewById(R.id.arrow);
        kirim = findViewById(R.id.kirim);
        imageview = findViewById(R.id.image_view);
        gantifoto = findViewById(R.id.gantifoto);

        gantifoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED){
                        String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else {
                        //permission already granted
                        pickImageFromGallery();

                    }
                }
                else{
                    pickImageFromGallery();

                }
            }
        });

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bayar2Activity.this, Home4.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Berhasil Menedaftarkan Event",Toast.LENGTH_SHORT).show();
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bayar2Activity.this, PremiumActivity.class);
                startActivity(intent);
            }
        });

        spinner = findViewById(R.id.bank);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bank, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery();
                }
                else {
                    Toast.makeText(this, "Izin Diperlukan...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            //set image to image view
            imageview.setImageURI(data.getData());
        }
    }
}
