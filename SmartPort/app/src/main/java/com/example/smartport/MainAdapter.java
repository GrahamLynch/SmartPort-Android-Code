package com.example.smartport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    JSONArray flightNum;
    String airlinename = "";
    String flightnum = "";
    public MainAdapter(JSONArray flightNum) {
        this.flightNum = flightNum;
    }



    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {

            for (int i = 0;i < flightNum.length();i++){
                try {
                    JSONObject data = flightNum.getJSONObject(i);
                    JSONObject airlineObject = data.getJSONObject("airline");
                    JSONObject flightObject = data.getJSONObject("flight");

                    airlinename += airlineObject.getString("name")+"\n";
                    flightnum += flightObject.getString("iataNumber")+"\n";

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                holder.flightNumber.setText(airlinename + flightnum);
            }



    }

    @Override
    public int getItemCount() {
        return flightNum.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView flightNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flightNumber = (TextView) itemView.findViewById(R.id.flight_num);
        }
    }
}
