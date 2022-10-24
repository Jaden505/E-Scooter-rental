import randomLocation from 'random-location'

class Scooter {
    constructor(id, tag, status, gpsLocation, mileage, batteryCharge) {
        this.id = id;
        this.tag = tag;
        this.status = status;
        this.gpsLocation = gpsLocation;
        this.mileage = mileage;
        this.batteryCharge = batteryCharge;
    }

    static createSampleScooter(pId = 0) {
        let states = ["IDLE", "INUSE", "MAINTENANCE"];
        let adam_longtitude = 4.897070;
        let adam_latitude = 52.377956;

        let id = pId;
        let tag = (Math.random() + 1).toString(36).substring(3); // Random 9 characters
        let status = states[Math.floor(Math.random() * states.length)]; // Random from array
        let gpsLocation = randomLocation.randomCirclePoint({latitude: adam_latitude, longitude: adam_longtitude}, 6000) // Random coordinates in region of Amsterdam
        let mileage = Math.floor(Math.random() * 10000000); // Random between a million and 0
        let batteryCharge = Math.floor(Math.random() * (100 - 5 + 1) + 5) // Random between 100 and 5

        return new Scooter(id, tag, status, gpsLocation, mileage, batteryCharge);
    }


    static copyConstructer (scooter){
        if (scooter === null || scooter == undefined){
            return null
        } else {
            return Object.assign(new Scooter(0),scooter)
        }
    }
}

export default Scooter;
