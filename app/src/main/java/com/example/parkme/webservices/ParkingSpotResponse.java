package com.example.parkme.webservices;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotResponse {

    private Properties properties;
//    private Properties placering;
//    private Properties antal;


    public ParkingSpot getParkingSpot()
    {
        return new ParkingSpot(properties.id, properties.placering, properties.antal);
    }

//    public List<ParkingSpot> getParkingSpotList(City city)
//    {
//        return new ArrayList<ParkingSpot>();
//    }
    private class Properties {
        private int id;
        private String placering;
        private int antal;
}
}


//placering string
//id int
//antal int
