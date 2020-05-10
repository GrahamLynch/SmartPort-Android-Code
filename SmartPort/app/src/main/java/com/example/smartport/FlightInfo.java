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



    public String getCurrentAirlineOnRunway() {
        return currentAirlineOnRunway;
    }



    public String getFlightNumber() {
        return flightNumber;
    }



    public String getDestination() {
        return destination;
    }



    public String getFlightStatus() {
        return flightStatus;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
