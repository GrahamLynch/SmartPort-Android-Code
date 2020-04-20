package com.example.smartport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    private EditText  password, email, name;
    private Button regButton;

    private FirebaseAuth firebaseAuth;
    TextView login;
    String airline, flightnumber, destination, passenger_name, flightStatus, landingTime, currentAirlineOnRunway;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        regButton = (Button)findViewById(R.id.registerBtn);
        firebaseAuth =  FirebaseAuth.getInstance();
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        airline = "";
        currentAirlineOnRunway = "";
        destination = "";
        flightStatus = "Not Landed";
        landingTime = "";
        flightnumber = "";

        regButton  = (Button)findViewById(R.id.registerBtn);
        login = (TextView) findViewById(R.id.loginTV);
        name = (EditText)findViewById(R.id.name);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Register data to database
                    String passenger_email  = email.getText().toString().trim();
                    String passenger_password = password.getText().toString().trim();
                    passenger_name = name.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(passenger_email, passenger_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                sendUserData();
                                new Intent(Registration.this, LoginActivity.class);
                            }else{
                                Toast.makeText(Registration.this,  "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Intent(Registration.this, LoginActivity.class);
            }
        });

    }

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        FlightInfo userProfile = new FlightInfo(airline , currentAirlineOnRunway, flightnumber, destination, flightStatus, landingTime, passenger_name);
        myRef.setValue(userProfile);
    }
}

