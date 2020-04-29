package com.example.smartport;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class PointsOfInterestActivityTest {
    @Rule
    public ActivityTestRule<PointsOfInterestActivity> PointsOfInterestActivityTestRule = new ActivityTestRule<>(PointsOfInterestActivity.class);

    private PointsOfInterestActivity PointsOfInterestActivity = null ;

    @Before
    public void setUp() throws Exception{
        PointsOfInterestActivity = PointsOfInterestActivityTestRule.getActivity();
    }

    @Test
    public void onCreate() {
        View RecyclerView = PointsOfInterestActivity.findViewById(R.id.poi_rview);
        assertNotNull(RecyclerView);
    }

    @After
    public void tearDown() throws Exception{
        PointsOfInterestActivity = null;
    }
}