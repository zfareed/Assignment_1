package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dayNames;
    ArrayList<Integer> images;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Days();
        AddImages();

        requestQueue = Volley.newRequestQueue(this);
        fetchJsonResponse();


        RecyclerView recyclerView = findViewById(R.id.rclrview);

        //Decoration - Divider between items
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        MyWeatherAdapter weatherAdapter = new MyWeatherAdapter(this, dayNames, images);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(weatherAdapter);


    }

    private void fetchJsonResponse() {
        // Pass second argument as "null" for GET requests
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, "https://api.openweathermap.org/data/2.5/onecall?lat=31.520370&lon=74.358749&units=metric&exclude=current,minutely,hourly,alerts&appid=b42ba87bf8677332eeea240472d2b78b", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Zain","Weather : "+response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        /* Add your Requests to the RequestQueue to execute */
        requestQueue.add(req);
    }

    public  void Days(){
            dayNames = new ArrayList<String>();
            dayNames.add("Sunday");
            dayNames.add("Monday");
            dayNames.add("Tuesday");
            dayNames.add("Wednesday");
            dayNames.add("Thursday");
            dayNames.add("Friday");
            dayNames.add("Saturday");
    }

    public void AddImages(){
        images = new ArrayList<Integer>();
        images.add(R.drawable.cloud_circle);
        images.add(R.drawable.cloud_circle);
        images.add(R.drawable.cloud_circle);
        images.add(R.drawable.cloud_circle);
        images.add(R.drawable.cloud_circle);
        images.add(R.drawable.cloud_circle);
        images.add(R.drawable.cloud_circle);
    }
}