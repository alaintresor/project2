package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class AddHarvest extends AppCompatActivity {
    EditText nameEditText, quantityEditText, priceEditText;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_harvest);

        final EditText user = (EditText) findViewById(R.id.h_name);
        quantityEditText = (EditText) findViewById(R.id.h_quantity);
        priceEditText = (EditText) findViewById(R.id.h_price);
        submit = findViewById(R.id.h_SubmitBtn);

        //get user ID
        final String userId = getIntent().getStringExtra("userId");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = String.valueOf(user.getText());
                final String quantity = String.valueOf(quantityEditText.getText());
                final String price = String.valueOf(priceEditText.getText());

                if (!name.equals("") && !quantity.equals("") && !price.equals("")) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "farmerId";
                            field[1] = "Harvests";
                            field[2] = "quantity";
                            field[3] = "price";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = userId;
                            data[1] = name;
                            data[2] = quantity;
                            data[3] = price;
                            PutData putData = new PutData("http://192.168.43.43/famer_facilition/addHarvest.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.toString().equals("Your Harvests Added")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                        intent.putExtra("userId",userId);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }

                                } else {

                                    Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
                                }
                            } else {

                                Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
                            }
                            //End Write and Read data with URL
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}