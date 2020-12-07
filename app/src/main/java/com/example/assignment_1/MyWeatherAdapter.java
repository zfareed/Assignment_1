package com.example.assignment_1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyWeatherAdapter extends RecyclerView.Adapter<MyWeatherAdapter.MyViewHolder> implements View.OnClickListener{

    Context context;
    public MyWeatherAdapter(Context context) {
        this.context = context;


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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.day.setText("Sunday");
        holder.description.setText("Today is very cold");
        holder.minTemp.setText("35");
        holder.maxTemp.setText("45");

        holder.itemView.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,WeatherActivity.class);
        context.startActivity(intent);
    }

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