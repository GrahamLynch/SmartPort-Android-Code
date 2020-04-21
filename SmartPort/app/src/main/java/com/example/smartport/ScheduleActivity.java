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

public class ScheduleActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_);

        mQueue = Volley.newRequestQueue(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);


        String url = "http://aviation-edge.com/v2/public/timetable?key=f69c83-32e515&iataCode=DUB&type=departure";


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Log.e("Response", response.toString());
                    jsonArray = response;
                    int size = jsonArray.length();
                    for (int i = 0; i < jsonArray.length(); i++) {            //********Commented out for loop to only get first element searched
                        JSONObject item = jsonArray.getJSONObject(i);

                        String airline = item.getString("airline") + "\n";

                        JSONObject jsonObject2 = item.getJSONObject("flight");
                        String iatacode = jsonObject2.getString("iataNumber") + "\n";


                        System.out.println("Hello" + jsonArray.length());
                        mAdapter = new MainAdapter(jsonArray);
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        mRecyclerView.setAdapter(mAdapter);

                    }                 //for loop closing brace
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

