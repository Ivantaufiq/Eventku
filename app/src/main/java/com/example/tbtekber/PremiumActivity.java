package com.example.tbtekber;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tbtekber.Transaksi.Bayar2Activity;

import java.util.Calendar;


public class PremiumActivity extends AppCompatActivity {
    private static final String TAG = "DataDiriActivity";
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    TextView tglevent;
    private int naik = 0;
    Button countup, countdown, daftar, gantifoto;
    TextView hasil;
    ImageView arrow, imageview;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium);
        countup = findViewById(R.id.countup);
        countdown = findViewById(R.id.countdown);
        gantifoto = findViewById(R.id.gantifoto);
        imageview = findViewById(R.id.image_view);
        hasil = findViewById(R.id.hasil);
        daftar = findViewById(R.id.daftar);
        tglevent =  findViewById(R.id.tglevent);
        arrow = findViewById(R.id.arrow);

        tglevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(PremiumActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month+1;
                Log.d(TAG, "onDateSet: dd/mm/yy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                tglevent.setText(date);
            }
        };

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

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PremiumActivity.this, Bayar2Activity.class);
                startActivity(intent);
            }
        });
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PremiumActivity.this, PilihDaftarEvent.class);
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

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

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
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE){
            //set image to image view
            imageview.setImageURI(data.getData());
        }
    }
}
