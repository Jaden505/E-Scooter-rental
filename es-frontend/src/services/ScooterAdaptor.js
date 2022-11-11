import Scooter from "@/models/scooter";

export class ScooterAdaptor{
    resourcesUrl;
    constructor(resourcesUrl) {
        this.resourcesUrl = resourcesUrl;
        console.log("Created ScooterAdaptor for " + resourcesUrl);
    }

    async fetchJson(URL, options = null){
        let response = await fetch(url,options)
        if (response.ok) {
            return await response.json();
        } else {

            console.log(response, !response.bodyUsed ? await response.text() : "");
            return null;
        }
    }

    async asyncFindALL() {
        console.log('ScooterAdaptor .asyncFindAll()...');
        const scooters = await this.fetchJson(this.resourcesUrl);
        return scooters?.map(s=>Scooter.copyConstructer(s));
    }

    async asyncFindbyId(id){
        console.log('ScooterAdaptor .asyncFindAll()...');
        const scooters = await this.fetchJson(this.resourcesUrl);
        return scooters?.stream().filter(scooter => scooter.getById == id).findFirst().orElse(null);

    }

    async asyncSave(scooter){
        console.log('ScooterAdaptor .asyncFindbyId()...');
        const scooters = await this.fetchJson(this.resourcesUrl);
        if (scooter.getId() == 0) {
            scooter.setId(scooterCount++);
        }
        scooters.add(scooter);
        return scooter;
    }

    async asyncDeleteById(id){
        console.log('ScooterAdaptor .asyncDeleteById()...');
        if (!scooter.equals(null)) {
            scooters.remove(scooter);
        }
        return scooter;
    }

}