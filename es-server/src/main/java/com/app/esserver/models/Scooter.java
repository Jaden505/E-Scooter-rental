package com.app.esserver.models;

import com.app.esserver.repositories.Identifable;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name="SCOOTER")
@NamedQueries({
        @NamedQuery(
                name = "select_all_scooters",
                query = "select p from Scooter p"
        ),
        @NamedQuery(
                name = "Scooter_find_by_status",
                query = "select p from Scooter p where p.status=?1"
        ),
        @NamedQuery(
                name = "Scooter_find_by_battery",
                query = "select p from Scooter p where p.batteryCharge=?1"
        )
})
public class Scooter implements Identifable {
    public static enum Status {
        IDLE,
        ACTIVE,
        MAINTENACE
    }

    @Id
    @GeneratedValue
    private long id;
    private String tag;
    private String status;
    private String gpsLocation;
    private int batteryCharge;
    private double mileage;
    private long currentTripId;

    @JsonManagedReference
    @OneToMany(mappedBy = "id")
    Set<Trip> trips;

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

    public Scooter() {
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

    public Set<Trip> getTrips() {
        return trips;
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    public long getCurrentTripId() {
        return currentTripId;
    }

    public void setCurrentTripId(long currentTripId) {
        this.currentTripId = currentTripId;
    }
}

