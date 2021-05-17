package com.example.parkme.webservices;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotResponse {

    private int id;
    private String placering;
    private int antal;
    private String paid;
    private String price;
//    private Properties properties;
//    private Properties placering;
//    private Properties antal;


    public ParkingSpot getParkingSpot()
    {
        return new ParkingSpot(id, placering, antal, paid, price);
    }

}


//placering string
//id int
//antal int
