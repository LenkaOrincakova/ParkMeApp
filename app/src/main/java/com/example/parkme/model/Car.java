package com.example.parkme.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "car_table")
public class Car implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String type;

    public Car(String name, String type)
    {
        this.name = name;
        this.type=type;
    }
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
