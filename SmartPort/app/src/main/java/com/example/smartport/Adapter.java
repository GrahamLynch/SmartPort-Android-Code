package com.example.smartport;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context mContext;
    List<cardItem> mData;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    String flight;



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
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        holder.background.setImageResource(mData.get(position).getBackground());
        holder.airline_logo.setImageResource(mData.get(position).getAirline_image());
        holder.airline_name.setText(mData.get(position).getAirline_name());
        holder.airline_route.setText(mData.get(position).getAirline_route());

            holder.choose_flight.setOnClickListener(new View.OnClickListener() {
                DatabaseReference databaseReference = firebaseDatabase.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
                @Override
                public void onClick(View view) {
                if (position == 0 || position == 2){
                    flight = "Ryanair";
                }
                else if (position == 1 || position == 3){
                        flight = "Aer Lingus";
                }
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                dataSnapshot.getRef().child("flight").setValue(flight);



                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });



                    Toast.makeText(view.getContext(),  "Student Registration Unsuccessful " + position, Toast.LENGTH_SHORT).show();


                }


            });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView background, airline_logo;
        TextView airline_name, airline_route;
        Button choose_flight;


        public myViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.card_background);
            background.setScaleType(ImageView.ScaleType.CENTER_CROP);
            airline_logo = itemView.findViewById(R.id.airline_image);
            airline_name = itemView.findViewById(R.id.airline_name);
            choose_flight = itemView.findViewById(R.id.flight_button);
            airline_route = itemView.findViewById(R.id.airline_route);
        }
    }

}
