package com.example.smartport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Schedule> schedule;
    public MainAdapter(Context ctx , List<Schedule> schedule) {
        this.inflater = LayoutInflater.from(ctx);
        this.schedule = schedule;
    }



    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {

         holder.airline.setText(schedule.get(position).getAirline());
         holder.route.setText("DUB - " + schedule.get(position).getDestination());
         holder.status.setText(schedule.get(position).getStatus());


    }

    @Override
    public int getItemCount() {
        return schedule.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView airline , route , status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            airline = (TextView) itemView.findViewById(R.id.airline);
            route = (TextView) itemView.findViewById(R.id.route);
            status = (TextView) itemView.findViewById(R.id.status);
        }
    }
}
