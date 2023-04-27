package com.parkmate;
import java.util.Random;

public class parkinglot {
    String name;
    int capacity;
    int occupancy;

    public parkinglot(String _name, int spaces) //at declaration, generates random occupancy
    {
        this.capacity = spaces;
        this.name = _name;
        this.occupancy = generate_Occupancy(capacity);
    }

    public static int generate_Occupancy(int maxcapacity)
    {
        Random rand = new Random();
        int occupancy = rand.nextInt(maxcapacity + 1);// generates random occupancy based on max capacity
        return occupancy;
    }
}