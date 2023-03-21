package com.app.esserver.models;

import com.app.esserver.repositories.Identifable;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.*;

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
    private long scooter_id;
    private String tag;
    private String status;
    private String gpsLocation;
    private int batteryCharge;
    private double mileage;
    private long currentTripId;

    @JsonManagedReference
    @OneToMany(mappedBy="scooter", cascade=CascadeType.ALL)
    List<Trip> trips = new ArrayList<Trip>();

    public Scooter(long id, String tag, String status, String gpsLocation, int batteryCharge, double mileage) {
        this.scooter_id = id;
        this.tag = tag;
        this.status = status;
        this.gpsLocation = gpsLocation;
        this.batteryCharge = batteryCharge;
        this.mileage = mileage;
    }

    public Scooter(String tag) {
        this.scooter_id = 0;
        this.tag = tag;
    }

    public Scooter(long id) {
        this.scooter_id = id;
    }

    public Scooter() {
        this.scooter_id = 0;
    }

    public static Scooter creatSampleScooter(long id){
        Random random = new Random();
        Scooter scooter = new Scooter(id);

        String[] state = {"IDLE", "ACTIVE", "MAINTENANCE"};
        scooter.setStatus(state[random.nextInt(state.length)]);

        scooter.setBatteryCharge(random.nextInt(100)); 

        scooter.setMileage(random.nextInt(500000));

        scooter.setGpsLocation(Integer.toString(random.nextInt(500000)) + ", " + Integer.toString(random.nextInt(500000)));

        scooter.setTag(Long.toHexString(Double.doubleToLongBits(Math.random())));

        return scooter;
    }
    public long getId() {
        return scooter_id;
    }

    public void setId(long id) {
        this.scooter_id = id;
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

    public List<Trip> getTrips() {
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

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}

