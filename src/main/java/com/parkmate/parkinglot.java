package com.parkmate;
import java.util.Random;

public class parkinglot {
    private int lots = 5;

    public parkinglot(int _lots)
    {
        this.lots = _lots;
    }

    public static int totalSlots = 500; //starts at 500, then gets updated when getTotalSlots is run
    // meaning that there's always going to be some occupency, make it realistic
    public static void createButtons()
    {

    }
    public static String getTotalSlots()
    {
        Random randomNum = new Random();
        int occupancyNum = randomNum.nextInt(500);
        String occupancyStr = "";
        occupancyStr += occupancyNum;
        totalSlots = occupancyNum;
        return occupancyStr;

    }

}