package com.example.smartport;

public class PointsOfInterest {
    String name;
    String location;
    String image;

    public PointsOfInterest() {
    }

    public PointsOfInterest(String name, String location, String image) {
        this.name = name;
        this.location = location;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
