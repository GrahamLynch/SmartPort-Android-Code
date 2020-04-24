package com.example.smartport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


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

public class UserProfileActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    FirebaseUser user;
    String name , email, airport, destination;
    TextView username,useremail,userairport,userdestination,mainname;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        username = (TextView)findViewById(R.id.name_tv);
        mainname = (TextView)findViewById(R.id.mainName_tv);
        useremail = (TextView) findViewById(R.id.email_tv);
        userairport = (TextView) findViewById(R.id.airport_tv);
        userdestination = (TextView) findViewById(R.id.destination_tv);
        back = (Button) findViewById(R.id.back_btn);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance();
        user = firebaseAuth.getCurrentUser();

        DatabaseReference databaseReference = firebaseDatabase.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FlightInfo userProfile = dataSnapshot.getValue(FlightInfo.class);
                name = userProfile.getName();
                destination = userProfile.getDestination();
                airport = userProfile.getOrigin();
                email = userProfile.getEmail();

                username.setText(name);
                userdestination.setText(destination);
                userairport.setText(airport);
                useremail.setText(email);
                mainname.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(UserProfileActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }

        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfileActivity.this, MainActivity.class));
            }
        });


    }


}
