package com.example.assignment_1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignment_1.WeatherData.WeatherData;

import java.util.ArrayList;

public class MyWeatherAdapter extends RecyclerView.Adapter<MyWeatherAdapter.MyViewHolder> implements View.OnClickListener{

    Context context;
    ArrayList<String> days;
    ArrayList<Integer> images;
    WeatherData myWeatherData;
    public MyWeatherAdapter(Context context, ArrayList<String> days, WeatherData weatherData) {
        this.context = context;
        this.days = days;
        this.images = images;
        this.myWeatherData = weatherData;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_weather_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.day.setText(days.get(position));
        final String imageURL =  "https://openweathermap.org/img/wn/"+ myWeatherData.getDaily().get(position).getWeather().get(0).getIcon() +"@2x.png";
        Glide.with(context).load(imageURL).into(holder.image);
        holder.description.setText(myWeatherData.getDaily().get(position).getWeather().get(0).getDescription());
        holder.minTemp.setText("min "+myWeatherData.getDaily().get(position).getTemp().getMin()+"");
        holder.maxTemp.setText("max "+myWeatherData.getDaily().get(position).getTemp().getMax()+"");

        //when clicked on any item
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,WeatherActivity.class);
                intent.putExtra("Position",position);
                intent.putExtra("Temp",myWeatherData.getDaily().get(position).getTemp().getDay());
                intent.putExtra("Discription",myWeatherData.getDaily().get(position).getWeather().get(0).getDescription());
                intent.putExtra("Feel Like",myWeatherData.getDaily().get(position).getFeelsLike().getDay());
                intent.putExtra("ImageURL",imageURL);
                intent.putExtra("Sunrise",myWeatherData.getDaily().get(position).getSunrise());
                intent.putExtra("Sunset",myWeatherData.getDaily().get(position).getSunset());
                intent.putExtra("Pressure",myWeatherData.getDaily().get(position).getPressure());
                intent.putExtra("Humidity",myWeatherData.getDaily().get(position).getHumidity());
                intent.putExtra("DewPoint",myWeatherData.getDaily().get(position).getDewPoint());
                intent.putExtra("Wind",myWeatherData.getDaily().get(position).getWindSpeed());
                intent.putExtra("TimeZone",myWeatherData.getTimezone());

                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    @Override
    public void onClick(View v) {

    }

   /* @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,WeatherActivity.class);
        intent.putExtra("zain",5);
        context.startActivity(intent);
    }*/

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView day,description,minTemp,maxTemp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            day= itemView.findViewById(R.id.dayView);
            description = itemView.findViewById(R.id.desView);
            minTemp = itemView.findViewById(R.id.minVew);
            maxTemp = itemView.findViewById(R.id.maxView);





        }
    }
}
