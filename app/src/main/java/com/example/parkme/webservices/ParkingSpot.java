package com.example.parkme.webservices;

public class ParkingSpot {

    private int id;
    private String placering;
    private int antal;

    public ParkingSpot(int id, String placering, int antal)
    {
        this.id = id;
        this.placering = placering;
        this.antal = antal;
    }

    public ParkingSpot()
    {

    }

    public int getId()
    {
        return id;
    }

    public int getAntal() {
        return antal;
    }

    public String getPlacering() {
        return placering;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public void setPlacering(String placering) {
        this.placering = placering;
    }
}
