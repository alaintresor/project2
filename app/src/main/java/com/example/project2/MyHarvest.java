package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyHarvest extends AppCompatActivity {
     ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_harvest);

        //get user ID
        final String userId = getIntent().getStringExtra("userId");

        listView=findViewById(R.id.Myharvest);

       final List<Harvests> Harvests;
       Harvests=new ArrayList<>();

        //get seeds from database
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {

                //Creating array for parameters
                String[] field = new String[1];
                field[0] = "farmerId";

                //Creating array for data
                String[] data = new String[1];
                data[0] = userId;

                PutData putData = new PutData("http://192.168.43.43/famer_facilition/getHarvest.php", "POST", field, data);
                if (putData.startPut()) {

                    String result = null;
                    if (putData.onComplete()) {
                        // progressBar.setVisibility(View.GONE);
                        result = putData.getResult();
                        if (!result.toString().equals("No harvest found")) {
                            try {
                                JSONArray array = new JSONArray(result);

                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject object = array.getJSONObject(i);
                                    String date = object.getString("date");
                                    String harvest = object.getString("harvest");
                                    String quantity = object.getString("quantity");
                                    String price = object.getString("price");

                                    Harvests.add(new Harvests(date,harvest,quantity,price));

                                }
                                harvestAdapter harvestAdapter=new harvestAdapter(getApplicationContext(),R.layout.single_harvest,Harvests);
                                listView.setAdapter(harvestAdapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        } else {

                        }
                    } else {
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                    }

                }
            }
            //End Write and Read data with URL

        });


    }
}