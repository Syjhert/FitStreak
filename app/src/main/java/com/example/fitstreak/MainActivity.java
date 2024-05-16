package com.example.fitstreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout WaterLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WaterLayout = (LinearLayout) findViewById(R.id.WaterLayout);
        WaterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToWaterActivity = new Intent(
                        MainActivity.this, WaterActivity.class
                );
                startActivity(intentToWaterActivity);
            }
        });
    }
}