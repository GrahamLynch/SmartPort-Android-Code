package com.example.smartport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.smartport.App.CHANNEL_1_ID;

public class PointsOfInterestActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    RecyclerView RecyclerView;
    PointsOfInterestAdapter adapter;
    private FirebaseAuth firebaseAuth;
    List<PointsOfInterest> poiList;
    FirebaseUser user;
    String URL, destination;
    private FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_of_interest);
        poiList = new ArrayList<>();
        adapter = new PointsOfInterestAdapter(this,poiList);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance();
        user = firebaseAuth.getCurrentUser();
        RecyclerView = (RecyclerView) findViewById(R.id.poi_rview);

        DatabaseReference databaseReference = firebaseDatabase.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FlightInfo userProfile = dataSnapshot.getValue(FlightInfo.class);
                destination = userProfile.getDestination();

                if(destination != null && destination.equals("Tenerife")){
                    URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=28.062587,-16.726852&rankby=distance&type=point_of_interest&key=AIzaSyBWG5Tgu1yPgkuBZVSMBnuh-2WD-FYiD2E";
                }
                else if(destination != null && destination.equals("London")){
                    URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=51.546106,-0.119543&rankby=distance&type=point_of_interest&key=AIzaSyBWG5Tgu1yPgkuBZVSMBnuh-2WD-FYiD2E";
                }
                else if (destination != null && destination.equals("Paris")){
                    URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=48.858549,2.348204&rankby=distance&type=point_of_interest&key=AIzaSyBWG5Tgu1yPgkuBZVSMBnuh-2WD-FYiD2E";
                }
                else if (destination != null && destination.equals("New York")){
                    URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=40.716960,-74.007093&rankby=distance&type=point_of_interest&key=AIzaSyBWG5Tgu1yPgkuBZVSMBnuh-2WD-FYiD2E";
                }

                System.out.println("Destination" + URL);
                jsonParse(URL);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(PointsOfInterestActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }

        });


    }

    private void jsonParse(String url){
        mQueue = Volley.newRequestQueue(this);

        String newURL = url;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, newURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("results");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        PointsOfInterest poi = new PointsOfInterest();
                        poi.setName(object.getString("name"));
                        poi.setLocation(object.getString("vicinity"));
                        poi.setImage(object.getString("icon"));
                        poiList.add(poi);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



                RecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new PointsOfInterestAdapter(getApplicationContext(),poiList);
                RecyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Response", error.toString());


            }
        });

        mQueue.add(request);
    }
}
