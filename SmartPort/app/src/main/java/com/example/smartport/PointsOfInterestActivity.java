package com.example.smartport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PointsOfInterestActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    TextView tView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_of_interest);
        tView = (TextView) findViewById(R.id.textView1);
        btn = (Button) findViewById(R.id.button2);


        mQueue = Volley.newRequestQueue(this);

        jsonParse();
    }

    private void jsonParse(){


        String url = "http://aviation-edge.com/v2/public/timetable?key=f69c83-32e515&iataCode=DUB&type=departure&airline_name=Aer Lingus";



        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Log.e("Response", response.toString());
                    JSONArray jsonArray = response;

                    for(int i =0; i<jsonArray.length(); i++){            //********Commented out for loop to only get first element searched
                    JSONObject item = jsonArray.getJSONObject(i);
                    String airline = item.getString("airline") + "\n";

                    JSONObject jsonObject2 = item.getJSONObject("flight");
                    String iatacode = jsonObject2.getString("iataNumber")+ "\n";



                    System.out.println("Hello" + jsonArray.length());
                    tView.append(iatacode);

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
