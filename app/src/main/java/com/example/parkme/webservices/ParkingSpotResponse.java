package com.example.parkme.webservices;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotResponse {

    private int parkingSpotId;
    private City cityEnum;


    public ParkingSpot getParkingSpot()
    {
        return new ParkingSpot(parkingSpotId, cityEnum);
    }

    public List<ParkingSpot> getParkingSpotList(City city)
    {
        return new ArrayList<ParkingSpot>();
    }
}
