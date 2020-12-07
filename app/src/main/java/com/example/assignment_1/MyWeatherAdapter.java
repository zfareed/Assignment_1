package com.example.assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyWeatherAdapter extends RecyclerView.Adapter<MyWeatherAdapter.MyViewHolder> {

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

    }

    @Override
    public int getItemCount() {
        return 7;
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
