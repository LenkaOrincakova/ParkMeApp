package com.example.parkme.webservices;

public class ParkingSpot {

    private int parkingSpotId;
    private City cityEnum;

    public ParkingSpot(int parkingSpotId, City cityEnum)
    {
        this.parkingSpotId = parkingSpotId;
        this.cityEnum = cityEnum;
    }

    public ParkingSpot()
    {

    }

    public int getParkingSpotId()
    {
        return parkingSpotId;
    }
    public City getCityEnum()
    {
        return cityEnum;
    }

    public void setParkingSpotId(int parkingSpotId)
    {
        this.parkingSpotId = parkingSpotId;
    }

    public void setCityEnum(City cityEnum)
    {
        this.cityEnum = cityEnum;
    }
}
