package com.example.smartport;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class UserProfileActivityTest {
    @Rule
    public ActivityTestRule<UserProfileActivity> UserProfileActivityTestRule = new ActivityTestRule<>(UserProfileActivity.class);

    private UserProfileActivity ProfileActivity = null ;

    @Before
    public void setUp() throws Exception{
        ProfileActivity = UserProfileActivityTestRule.getActivity();
    }
    @Test
    public void onCreate() {
        View nameView = ProfileActivity.findViewById(R.id.name_tv);
        View emailView = ProfileActivity.findViewById(R.id.email_tv);
        View airportView = ProfileActivity.findViewById(R.id.airport_tv);
        View destinationView = ProfileActivity.findViewById(R.id.destination_tv);
        assertNotNull(nameView);
        assertNotNull(emailView);
        assertNotNull(airportView);
        assertNotNull(destinationView);

    }

    @After
    public void tearDown() throws Exception{
        ProfileActivity = null;
    }
}