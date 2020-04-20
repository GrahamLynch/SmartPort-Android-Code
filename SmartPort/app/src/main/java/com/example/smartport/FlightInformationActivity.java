package com.example.smartport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FlightInformationActivity extends AppCompatActivity {
    TextView airline_tv , gate_tv , route_tv , flightno_tv , status_tv, time_tv, terminal_tv;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_information);
        airline_tv = (TextView) findViewById(R.id.airline_textView);
        gate_tv = (TextView) findViewById(R.id.gate_textView);
        route_tv = (TextView) findViewById(R.id.route_textView);
        flightno_tv = (TextView) findViewById(R.id.flightNo_textView);
        status_tv = (TextView) findViewById(R.id.status_textView);
        time_tv = (TextView) findViewById(R.id.time_textView);

        FirebaseUser user;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance();
        user = firebaseAuth.getCurrentUser();

        DatabaseReference databaseReference = firebaseDatabase.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FlightInfo userProfile = dataSnapshot.getValue(FlightInfo.class);
                String airline = userProfile.getChosenAirline();
                String destination = userProfile.getDestination();
                String flightNumber = userProfile.getFlightNumber();
                String status = userProfile.getFlightStatus();

                if(airline.equals("")){
                    airline_tv.setText("Please Select a Flight");
                    route_tv.setText("Please Select a Flight");
                    flightno_tv.setText("Please Select a Flight");
                    status_tv.setText("Please Select a Flight");
                    gate_tv.setText("Please Select a Flight");
                    time_tv.setText("Please Select a Flight");


                }
                else {
                    airline_tv.setText(airline);
                    route_tv.setText(destination);
                    flightno_tv.setText(flightNumber);
                    status_tv.setText(status);
                    gate_tv.setText("3");
                    time_tv.setText("15:00");

                }




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });



    }
}
