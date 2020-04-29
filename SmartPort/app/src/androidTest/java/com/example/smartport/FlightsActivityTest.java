package com.example.smartport;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class FlightsActivityTest {
    @Rule
    public ActivityTestRule<FlightsActivity> flightActivityTestRule = new ActivityTestRule<>(FlightsActivity.class);

    private FlightsActivity flightActivity = null ;

    @Before
    public void setUp() throws Exception{
        flightActivity = flightActivityTestRule.getActivity();
    }

    @Test
    public void onCreate() {
        View RecyclerView = flightActivity.findViewById(R.id.rv_list);

        assertNotNull(RecyclerView);

    }

    @After
    public void tearDown() throws Exception{
        flightActivity = null;
    }
}