package com.example.smartport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    RecyclerView mRecyclerView;
    List<Schedule> schedule;
    ScehduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        schedule = new ArrayList<>();
        jsonParse();
    }




    public void jsonParse() {
        mQueue = Volley.newRequestQueue(this);
        String url = "http://aviation-edge.com/v2/public/timetable?key=f69c83-32e515&iataCode=DUB&type=departure";


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject data = response.getJSONObject(i);
                        JSONObject airlineObject = data.getJSONObject("airline");
                        JSONObject arrivalObject = data.getJSONObject("arrival");
                        Schedule schedules = new Schedule();
                        schedules.setAirline(airlineObject.getString("name"));
                        schedules.setDestination(arrivalObject.getString("iataCode"));
                        schedules.setStatus(data.getString("status"));
                        schedule.add(schedules);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new ScehduleAdapter(getApplicationContext() , schedule);
                mRecyclerView.setAdapter(adapter);

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

