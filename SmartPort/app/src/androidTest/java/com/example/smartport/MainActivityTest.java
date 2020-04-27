package com.example.smartport;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null ;
    @Before
    public void setUp() throws Exception{
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void onCreate() {
        View selectFlightView = mActivity.findViewById(R.id.selectFlightTv);
        View viewFlightInfoView = mActivity.findViewById(R.id.viewFlightInfoTv);
        View pointsOfInterestView = mActivity.findViewById(R.id.pointsOfInterestTv);
        View scheduleView = mActivity.findViewById(R.id.scedhuleTv);
        View profileView = mActivity.findViewById(R.id.profileTv);
        View logoutView = mActivity.findViewById(R.id.logoutTv);
        assertNotNull(selectFlightView);
        assertNotNull(viewFlightInfoView);
        assertNotNull(pointsOfInterestView);
        assertNotNull(scheduleView);
        assertNotNull(profileView);
        assertNotNull(logoutView);
    }
    /*
    @Test
    public void onClick() {
    }

     */

    @After
    public void tearDown() throws Exception{
        mActivity = null;
    }
}