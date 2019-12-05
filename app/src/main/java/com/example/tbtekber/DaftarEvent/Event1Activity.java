package com.example.tbtekber.DaftarEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tbtekber.CariEventActivity;
import com.example.tbtekber.R;

public class Event1Activity extends AppCompatActivity {
    LinearLayout expandableView;
    Button arrowBtn, gps1;
    CardView cardView;
    ImageView arrow;
    TextView textloc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);
        expandableView = findViewById(R.id.expandableView);
        arrowBtn = findViewById(R.id.arrowBtn);
        cardView = findViewById(R.id.cardView);
        gps1 = findViewById(R.id.gps1);
        arrow = findViewById(R.id.arrow);
        textloc = findViewById(R.id.textloc);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Event1Activity.this, CariEventActivity.class);
                startActivity(intent);
            }
        });


    }

    public void deskripsi1(View view) {
        if (expandableView.getVisibility()==View.GONE){
            TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
            expandableView.setVisibility(View.VISIBLE);
            arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_blue_24dp);
        } else {
            TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
            expandableView.setVisibility(View.GONE);
            arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_right_blue_24dp);
        }
    }

    public void OpenLocation(View view) {
        String loc = textloc.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
