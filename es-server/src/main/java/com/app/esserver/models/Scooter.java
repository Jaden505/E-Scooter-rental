package com.app.esserver.models;

import java.util.ArrayList;
import java.util.Random;
public class Scooter {

    private long id;
    private String tag;
    private String status;
    private String gpsLocation;
    private int batteryCharge;
    private double mileage;

    public Scooter(long id, String tag, String status, String gpsLocation, int batteryCharge, double mileage) {
        this.id = id;
        this.tag = tag;
        this.status = status;
        this.gpsLocation = gpsLocation;
        this.batteryCharge = batteryCharge;
        this.mileage = mileage;
    }

    public Scooter(String tag) {
        id = 0;
        this.tag = tag;
        status = null;
        gpsLocation = null ;
        batteryCharge = 0;
        mileage = 0.0;
    }

    public Scooter(long id) {
    }

    public static Scooter creatSampleScooter(long id){
        Random random = new Random();
        Scooter scooter = new Scooter(id);

        scooter.setId(id);

        String[] state = {"IDLE", "ACTIVE", "MAINTENANCE"};
        scooter.setStatus(state[random.nextInt(state.length)]);

        scooter.setBatteryCharge(random.nextInt(100)); 

        scooter.setMileage(random.nextInt(500000));

        scooter.setGpsLocation(Integer.toString(random.nextInt(500000)) + ", " + Integer.toString(random.nextInt(500000)));

        scooter.setTag(Long.toHexString(Double.doubleToLongBits(Math.random())));

        return scooter;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public int getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
