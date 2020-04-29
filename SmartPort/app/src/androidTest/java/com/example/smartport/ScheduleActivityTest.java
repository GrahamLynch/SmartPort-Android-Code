package com.example.smartport;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.assertNotNull;

public class ScheduleActivityTest {
    @Rule
    public ActivityTestRule<ScheduleActivity> ScheduleActivityTestRule = new ActivityTestRule<>(ScheduleActivity.class);

    private ScheduleActivity ScheduleActivity = null ;

    @Before
    public void setUp() throws Exception{
        ScheduleActivity = ScheduleActivityTestRule.getActivity();
    }

    @Test
    public void onCreate() {
        View RecyclerView = ScheduleActivity.findViewById(R.id.recycler_view);
        assertNotNull(RecyclerView);
    }

    @Test
    public void jsonParse() {
        View RecyclerView = ScheduleActivity.findViewById(R.id.recycler_view);
        assertNotNull(RecyclerView);
    }

    @After
    public void tearDown() throws Exception{
        ScheduleActivity = null;
    }
}