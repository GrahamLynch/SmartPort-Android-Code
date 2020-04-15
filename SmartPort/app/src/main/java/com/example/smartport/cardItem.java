package com.example.smartport;

public class cardItem {

    int background;
    String airline_name;
    String airline_route;
    int airline_image;


    public cardItem() {
    }

    public cardItem(int background, String airline_name, String airline_route, int airline_image) {
        this.background = background;
        this.airline_name = airline_name;
        this.airline_route = airline_route;
        this.airline_image = airline_image;
    }

    public int getBackground() {
        return background;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public String getAirline_route() {
        return airline_route;
    }

    public int getAirline_image() {
        return airline_image;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public void setAirline_route(String airline_route) {
        this.airline_route = airline_route;
    }

    public void setAirline_image(int airline_image) {
        this.airline_image = airline_image;
    }
}
