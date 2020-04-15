package com.example.smartport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context mContext;
    List<cardItem> mData;

    public Adapter(Context mContext, List<cardItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.card_item, parent, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.background.setImageResource(mData.get(position).getBackground());
        holder.airline_logo.setImageResource(mData.get(position).getAirline_image());
        holder.airline_name.setText(mData.get(position).getAirline_name());
        holder.airline_route.setText(mData.get(position).getAirline_route());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView background, airline_logo;
        TextView airline_name, airline_route;


        public myViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.card_background);
            background.setScaleType(ImageView.ScaleType.CENTER_CROP);
            airline_logo = itemView.findViewById(R.id.airline_image);
            airline_name = itemView.findViewById(R.id.airline_name);
            airline_route = itemView.findViewById(R.id.airline_route);
        }
    }

}
