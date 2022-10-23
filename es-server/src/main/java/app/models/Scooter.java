package app.models;

public class Scooter {

    private long id;
    private String tag;
    private String status;
    private String gpsLocation;
    private int batteryCharge;
    private int mileage;

    public Scooter(long id, String tag, String status, String gpsLocation, int batteryCharge, int mileage) {
        this.id = id;
        this.tag = tag;
        this.status = status;
        this.gpsLocation = gpsLocation;
        this.mileage = mileage;
        this.batteryCharge = batteryCharge;
    }



    public Scooter(long id) {
    }

//    public Scooter createRepository(long id){
//        Scooter scooter = new Scooter(id);
//
//    }




}
