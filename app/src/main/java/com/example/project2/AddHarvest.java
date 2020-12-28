package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddHarvest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_harvest);
        TextView textView=(TextView)findViewById(R.id.textView);
        final String data = getIntent().getStringExtra("data");
        textView.setText(data);
    }
}