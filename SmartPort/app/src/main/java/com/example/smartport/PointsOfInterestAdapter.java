package com.example.smartport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PointsOfInterestAdapter extends RecyclerView.Adapter<PointsOfInterestAdapter.ViewHolder>{

    LayoutInflater inflater;
    List<PointsOfInterest> poi;

    public PointsOfInterestAdapter(Context c , List<PointsOfInterest> poi){
        this.inflater = LayoutInflater.from(c);
        this.poi = poi;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poi_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PointsOfInterestAdapter.ViewHolder holder, int position) {
        holder.name.setText(poi.get(position).getName());
        holder.location.setText(poi.get(position).getLocation());
        Picasso.get().load(poi.get(position).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return poi.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name , location;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            location = itemView.findViewById(R.id.location);
            image = itemView.findViewById(R.id.destinationImage);

        }
    }
}
