package com.example.smartport;

public class UserProfile {
    String airline;
    String flightNumber;
    String destination;
    String flightStatus;
    String landingTime;
    String name;


    public UserProfile(){

    }

    public UserProfile(String airline, String flightNumber, String destination, String flightStatus, String landingTime, String name) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.flightStatus = flightStatus;
        this.landingTime = landingTime;
        this.name = name;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(String landingTime) {
        this.landingTime = landingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
