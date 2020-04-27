package com.example.smartport;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null ;

    Instrumentation.ActivityMonitor flightsActivityMonitor = getInstrumentation().addMonitor(FlightsActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor flightsInfoActivityMonitor = getInstrumentation().addMonitor(FlightInformationActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor pointsOfInterestActivityMonitor = getInstrumentation().addMonitor(PointsOfInterestActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor scheduleActivityMonitor = getInstrumentation().addMonitor(ScheduleActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor userProfileActivityMonitor = getInstrumentation().addMonitor(UserProfileActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor loginActivityMonitor = getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false);
    //yourFlightInformation
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



    @Test
    public void onClick() {
        assertNotNull(mActivity.findViewById(R.id.yourFlights));
        assertNotNull(mActivity.findViewById(R.id.yourFlightInformation));
        assertNotNull(mActivity.findViewById(R.id.pointsOfInterest));
        assertNotNull(mActivity.findViewById(R.id.scedhule));
        assertNotNull(mActivity.findViewById(R.id.userProfile));
        assertNotNull(mActivity.findViewById(R.id.logout));

        onView(withId(R.id.yourFlights)).perform(click());
        Activity flightsActivity =  getInstrumentation().waitForMonitorWithTimeout(flightsActivityMonitor,5000);
        assertNotNull(flightsActivity);
        flightsActivity.finish();





    }

    @After
    public void tearDown() throws Exception{
        mActivity = null;
    }
}