package com.example.smartport;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class FlightInformationActivityTest {
    @Rule
    public ActivityTestRule<FlightInformationActivity> flightInformationActivityTestRule = new ActivityTestRule<>(FlightInformationActivity.class);

    private FlightInformationActivity flightInformationActivity = null ;

    @Before
    public void setUp() throws Exception{
        flightInformationActivity = flightInformationActivityTestRule.getActivity();
    }

    @Test
    public void onCreate() {
        View airlineView = flightInformationActivity.findViewById(R.id.airline_tv);
        View routeView = flightInformationActivity.findViewById(R.id.route_tv);
        View flightNoView = flightInformationActivity.findViewById(R.id.flightNo_tv);
        View timeView = flightInformationActivity.findViewById(R.id.time_tv);
        View gateView = flightInformationActivity.findViewById(R.id.gate_tv);
        View statusView = flightInformationActivity.findViewById(R.id.status_tv);
        assertNotNull(airlineView);
        assertNotNull(routeView);
        assertNotNull(flightNoView);
        assertNotNull(timeView);
        assertNotNull(gateView);
        assertNotNull(statusView);
    }

    @After
    public void tearDown() throws Exception{
        flightInformationActivity = null;
    }
}