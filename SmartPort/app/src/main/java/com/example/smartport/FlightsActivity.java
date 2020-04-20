package com.example.smartport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FlightsActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    List <cardItem> mlist = new ArrayList<>();
    Button btn;
    TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        // Set status bar to transparent
        mQueue = Volley.newRequestQueue(this);
        btn = (Button) findViewById(R.id.button2);
        test = (TextView) findViewById(R.id.textViewtest);
        RecyclerView recyclerView = findViewById(R.id.rv_list);

        mlist.add(new cardItem(R.drawable.tenerife, "Ryanair", "Dublin to Tenerife", R.drawable.ryanair));
        mlist.add(new cardItem(R.drawable.paris, "Aer Lingus", "Dublin to Paris", R.drawable.aerlingus));
        mlist.add(new cardItem(R.drawable.london, "Ryanair", "Dublin to London", R.drawable.ryanair));
        mlist.add(new cardItem(R.drawable.newyork, "Aer Lingus", "Dublin to New York", R.drawable.aerlingus));

        Adapter adapter = new Adapter(this, mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }



    private void jsonParse(){


        String url = "http://aviation-edge.com/v2/public/timetable?key=f69c83-32e515&iataCode=DUB&type=departure";



        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("airline");

//                    for(int i =0; i<jsonArray.length(); i++){            //********Commented out for loop to only get first element searched
                    JSONObject item = jsonArray.getJSONObject(0);

                    String productName = item.getString("name") + "\n";

                    test.append(productName);


//                    }                 //for loop closing brace
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
        Toast.makeText(FlightsActivity.this,  "Hello", Toast.LENGTH_SHORT).show();
    }
}
