package com.example.smartport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private NotificationManagerCompat notificationManager;
    private CardView selectedFlights, flightInformation, pointsOfInterest, userProfile, logout;
    private String airline, flightStatus;
    private int num1 = 1;
    FirebaseUser user;
    Boolean status = true;
    private TextView header;
    private String Airline;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedFlights = (CardView) findViewById(R.id.yourFlights);
        flightInformation = (CardView) findViewById(R.id.yourFlightInformation);
        pointsOfInterest = (CardView) findViewById(R.id.pointsOfInterest);
        userProfile = (CardView) findViewById(R.id.userProfile);
        logout = (CardView) findViewById(R.id.logout);
        //Set on Click Listeners
        selectedFlights.setOnClickListener(this);
        flightInformation.setOnClickListener(this);
        pointsOfInterest.setOnClickListener(this);
        userProfile.setOnClickListener(this);
        logout.setOnClickListener(this);

        notificationManager = NotificationManagerCompat.from(this);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance();
        user = firebaseAuth.getCurrentUser();

        DatabaseReference databaseReference = firebaseDatabase.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                airline = userProfile.getAirline();
                flightStatus = userProfile.getFlightStatus();

                if(airline != null && airline.equals("Ryanair") && flightStatus.equals("Landed")){
                    Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.ryanair)
                            .setContentTitle("Ryanair")
                            .setContentText("Ryanair has landed!")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .build();
                    notificationManager.notify(1, notification);
                }

                else if(airline != null  && airline.equals("Aer Lingus") && flightStatus.equals("Landed")){
                    Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_1_ID)
                            .setSmallIcon(R.drawable.aerlingus)
                            .setContentTitle("Aer Lingus")
                            .setContentText("Aer Lingus has landed!")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .build();
                    notificationManager.notify(1, notification);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }

        });





    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.yourFlights: i = new Intent(this,FlightsActivity.class); startActivity(i); break;
            case R.id.yourFlightInformation: i = new Intent(this,FlightInformationActivity.class); startActivity(i); break;
            case R.id.pointsOfInterest: i = new Intent(this,PointsOfInterestActivity.class); startActivity(i); break;
            case R.id.userProfile: i = new Intent(this,UserProfileActivity.class); startActivity(i); break;
            case R.id.logout: i = new Intent(this,LoginActivity.class); startActivity(i); break;
            default: break ;
        }


    }
}
