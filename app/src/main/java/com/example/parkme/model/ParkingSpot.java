package com.example.parkme.model;

public class ParkingSpot {

    private int id;
    private String placering;
    private int antal;
    private String paid;
    private String price;

    public ParkingSpot(int id, String placering, int antal, String paid, String price)
    {
        this.id = id;
        this.placering = placering;
        this.antal = antal;
        this.paid = paid;
        this.price = price;
    }

    public ParkingSpot()
    {}

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

    public String getPaid() {
        return paid;
    }

    public String getPrice() {
        return price;
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

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                ", placering='" + placering + '\'' +
                ", antal=" + antal +
                ", paid=" + paid +
                ", price=" + price +

                '}';
    }
}
