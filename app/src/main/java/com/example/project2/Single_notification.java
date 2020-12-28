package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Single_notification extends AppCompatActivity {
    TextView subjectTextView,dateTextView,bodyTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_notification);
        subjectTextView=findViewById(R.id.sub);
        dateTextView=findViewById(R.id.date);
        bodyTextView=findViewById(R.id.body);

        String subject=getIntent().getStringExtra("subject");
        String date=getIntent().getStringExtra("date");
        String msg=getIntent().getStringExtra("msg");
        subjectTextView.setText(subject);
        dateTextView.setText(date);
        bodyTextView.setText(msg);
    }
}