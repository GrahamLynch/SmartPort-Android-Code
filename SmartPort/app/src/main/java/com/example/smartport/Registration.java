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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;

public class Registration extends AppCompatActivity {
    private EditText studentNumber, studentPassword, studentEmail, studentName;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    String student_number;
    String airline;
    String student_password;
    String student_email;
    String student_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        regButton = (Button)findViewById(R.id.registerBtn);
        userLogin = (TextView) findViewById(R.id.tvUserLogin);
        firebaseAuth =  FirebaseAuth.getInstance();
        studentPassword = (EditText)findViewById(R.id.etUserPassword);
        studentEmail = (EditText)findViewById(R.id.etUserEmail);
        airline = "Not";
        regButton  = (Button)findViewById(R.id.registerBtn);
        userLogin = (TextView)findViewById(R.id.tvUserLogin);
        studentName = (EditText)findViewById(R.id.nameText);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Register data to database
                    String student_email  = studentEmail.getText().toString().trim();
                    String student_password = studentPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(student_email, student_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                sendUserData();


                            }else{
                                Toast.makeText(Registration.this,  "Student Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });


            }
        });


    }








    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile = new UserProfile(airline);
        myRef.setValue(userProfile);
    }
}

