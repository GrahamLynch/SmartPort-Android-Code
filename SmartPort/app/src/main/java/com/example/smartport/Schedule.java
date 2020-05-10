package com.example.smartport;

public class Schedule {
    private String airline;
    private String destination;
    private String status;

    public Schedule() {
    }

    public Schedule(String airline, String destination, String status) {
        this.airline = airline;
        this.destination = destination;
        this.status = status;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
