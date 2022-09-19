class Scooter {
    states = ["IDLE", "INUSE", "MAINTENANCE"];
    adam_longtitude = 4.897070;
    adam_lattitude = 52.377956;

    constructor(id, tag, status, gpsLocation, mileage, batteryCharge) {
        this.id = id;
        this.tag = tag;
        this.status = status;
        this.gpsLocation = gpsLocation;
        this.mileage = mileage;
        this.batteryCharge = batteryCharge;
    }

    static createSampleScooter(pId = 0) {
        let id = pId;
        let tag = (Math.random() + 1).toString(36).substring(7); // Random 8 characters
        let status = this.states[Math.floor(Math.random() * this.states.length)]; // Random from array
        let gpsLocation = (Math.random() * (this.adam_lattitude - this.adam_longtitude) + this.adam_longtitude).toFixed(3) * 1; // Random between coordinates
        let mileage = Math.floor(Math.random() * 10000000); // Random between a million and 0
        let batteryCharge = Math.floor(Math.random() * (100 - 5 + 1) + 5) // Random between 100 and 5

        return new Scooter(id, tag, status, gpsLocation, mileage, batteryCharge);
    }
}