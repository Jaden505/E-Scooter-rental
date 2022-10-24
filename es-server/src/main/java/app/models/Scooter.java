package app.models;

import java.util.ArrayList;

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
    Scooter scooter = new Scooter(id);

    ArrayList<Scooter> scootersSamples = new ArrayList<>();
    Scooter sample1 = new Scooter(0,"qewdq-qw","INLDE","4324321113232424",100,0.0);
    Scooter sample2 = new Scooter(1,"dsdwq-qw","INLDE","43243232424",50,0.0);
    Scooter sample3 = new Scooter(2,"jhjytj-qw","INLDE","542424",20,0.0);
    Scooter sample4 = new Scooter(3,"eqewq-few","INLDE","5443543",80,0.0);
    Scooter sample5 = new Scooter(4,"fqwe-qw","INLDE","7675576",20,0.0);
    Scooter sample6 = new Scooter(5,"u76-qw","INLDE","2432",90,0.0);
    Scooter sample7 = new Scooter(6,"e112e-qw","INLDE","677",44,0.0);

    scootersSamples.add(sample1);
    scootersSamples.add(sample2);
    scootersSamples.add(sample3);
    scootersSamples.add(sample4);
    scootersSamples.add(sample5);
    scootersSamples.add(sample6);
    scootersSamples.add(sample7);

        return null;
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
