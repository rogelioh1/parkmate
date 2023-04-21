package com.parkmate;

public class parkinglot {
    int capacity;
    int currentOccupancy;
    int occupancyRate;
    String lotName;
    int zone;
    public parkinglot(int zone, int capacity, int currentOccupancy, String lotName) {
        this.zone = zone;
        this.capacity = capacity;
        this.currentOccupancy = currentOccupancy;
        this.lotName = lotName;
    }

}

