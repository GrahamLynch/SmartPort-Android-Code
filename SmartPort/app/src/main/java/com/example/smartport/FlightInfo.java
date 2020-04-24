package com.example.smartport;

public class FlightInfo {
    String chosenAirline;
    String currentAirlineOnRunway;
    String flightNumber;
    String destination;
    String flightStatus;
    String landingTime;
    String email;
    String origin;
    String name;


    public FlightInfo(){

    }

    public FlightInfo(String chosenAirline, String currentAirlineOnRunway, String flightNumber, String destination, String flightStatus, String landingTime, String email, String origin, String name) {
        this.chosenAirline = chosenAirline;
        this.currentAirlineOnRunway = currentAirlineOnRunway;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.flightStatus = flightStatus;
        this.landingTime = landingTime;
        this.email = email;
        this.origin = origin;
        this.name = name;
    }

    public String getChosenAirline() {
        return chosenAirline;
    }

    public void setChosenAirline(String chosenAirline) {
        this.chosenAirline = chosenAirline;
    }

    public String getCurrentAirlineOnRunway() {
        return currentAirlineOnRunway;
    }

    public void setCurrentAirlineOnRunway(String currentAirlineOnRunway) {
        this.currentAirlineOnRunway = currentAirlineOnRunway;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
