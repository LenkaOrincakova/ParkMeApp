package com.example.parkme.architecture.webservices;

import com.example.parkme.model.ParkingSpot;

public class ParkingSpotResponse {

    private int id;
    private String placering;
    private int antal;
    private String paid;
    private String price;

    public ParkingSpot getParkingSpot()
    {
        return new ParkingSpot(id, placering, antal, paid, price);
    }
}