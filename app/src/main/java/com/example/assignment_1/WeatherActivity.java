package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.gesture.GestureLibraries;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.assignment_1.WeatherData.WeatherData;

public class WeatherActivity extends AppCompatActivity {

    ImageView imageView;
    TextView disc;
    TextView tempr;
    TextView Feels_Like;
    TextView sunset;
    TextView sunrise;
    TextView pressure;
    TextView humidity;
    TextView dewpoint;
    TextView windsped;
    TextView timezone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);

        imageView = findViewById(R.id.mainImage);
        disc = findViewById(R.id.disc);
        tempr = findViewById(R.id.temp);
        Feels_Like = findViewById(R.id.feelslike);
        sunrise = findViewById(R.id.sunrisetime);
        sunset = findViewById(R.id.sunsettime);
        pressure = findViewById(R.id.pressurevalue);
        dewpoint = findViewById(R.id.dewpointvalue);
        humidity = findViewById(R.id.humidityvalue);
        windsped = findViewById(R.id.windspeed);
        timezone = findViewById(R.id.timezone);



        Intent intent = getIntent();
        Double Temp = intent.getDoubleExtra("Temp",10);
        String Discription = intent.getStringExtra("Discription");
        Double Feels_like = intent.getDoubleExtra("Feels Like", 10);
        String ImageURL = intent.getStringExtra("ImageURL");
        Integer Sunrise = intent.getIntExtra("Sunrise",10);
        Integer Sunset = intent.getIntExtra("Sunset",10);
        Integer Pressure = intent.getIntExtra("Pressure",10);
        Integer Humidity = intent.getIntExtra("Humidity",10);
        Double WindSpeed = intent.getDoubleExtra("Wind",10);
        Double Dewpoint = intent.getDoubleExtra("Dewpoint",10);
        String TimeZone = intent.getStringExtra("TimeZone");



        Glide.with(this).load(ImageURL).fitCenter().into(imageView);
        disc.setText(Discription);
        Feels_Like.setText("Feels like : "+Feels_like+" C");
        tempr.setText(Temp+" C");
        sunrise.setText(Sunrise+"");
        sunset.setText(Sunset+"");
        pressure.setText(Pressure+" hP");
        humidity.setText(Humidity+" %");
        windsped.setText(WindSpeed+" m/s");
        dewpoint.setText(Dewpoint+" C");
        timezone.setText(TimeZone);












    }
}