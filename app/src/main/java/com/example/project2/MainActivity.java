package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView notification;
    CardView manuel;
    CardView AddHarvest;
    CardView MyHarvest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification=findViewById(R.id.notification);
        manuel=findViewById(R.id.manuel);
        AddHarvest=findViewById(R.id.addHarvest);
        MyHarvest=findViewById(R.id.harvest);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Notification.class);
                startActivity(intent);
            }
        });

        manuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Apply.class);
                startActivity(intent);
            }
        });

        MyHarvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MyHarvest.class);
                startActivity(intent);
            }
        });

        AddHarvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AddHarvest.class);
                startActivity(intent);
            }
        });
    }
}