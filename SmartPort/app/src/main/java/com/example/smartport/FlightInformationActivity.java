package com.example.smartport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.smartport.App.CHANNEL_1_ID;

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
        terminal_tv = (TextView) findViewById(R.id.terminal_textView);
        FirebaseUser user;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance();
        user = firebaseAuth.getCurrentUser();

        DatabaseReference databaseReference = firebaseDatabase.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                String airline = userProfile.getAirline();
                String destination = userProfile.getDestination();
                String flightNumber = userProfile.getFlightNumber();
                String status = userProfile.getFlightStatus();


                airline_tv.setText(airline);
                route_tv.setText(destination);
                flightno_tv.setText(flightNumber);
                status_tv.setText(status);
                gate_tv.setText("3");
                time_tv.setText("15:00");
                terminal_tv.setText("2");


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }
}
