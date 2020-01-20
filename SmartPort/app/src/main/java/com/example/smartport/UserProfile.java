package com.example.smartport;

public class UserProfile {
    String flight;

    public UserProfile(){

    }

    public UserProfile(String flight){
        this.flight = flight;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }
}
