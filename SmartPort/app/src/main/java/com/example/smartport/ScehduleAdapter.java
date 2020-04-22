package com.example.smartport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ScehduleAdapter extends RecyclerView.Adapter<ScehduleAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Schedule> schedule;
    public ScehduleAdapter(Context ctx , List<Schedule> schedule) {
        this.inflater = LayoutInflater.from(ctx);
        this.schedule = schedule;
    }



    @NonNull
    @Override
    public ScehduleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scedhule_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScehduleAdapter.ViewHolder holder, int position) {

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
