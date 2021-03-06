package com.example.smartport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.analytics.FirebaseAnalytics;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private TextView emailAddress, password;
    ImageView back;
    FirebaseUser user;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        login = (Button) findViewById(R.id.loginBtn);
        back = (ImageView) findViewById(R.id.goBack);


        emailAddress = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);

        user = firebaseAuth.getCurrentUser();




        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                validate(emailAddress.getText().toString(), password.getText().toString());
            }
        });


    }

    private void validate(String email, String password) {

        Toast.makeText(LoginActivity.this, "Logging into your account!", Toast.LENGTH_SHORT);


        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();



                }
            }
        });


    }


    public void goback(View view) {
        Intent i = new Intent(LoginActivity.this, Registration.class);
        startActivity(i);
    }


}