import Scooter from "@/models/scooter";

export class ScooterAdaptor{
    resourcesUrl;
    constructor(resourcesUrl) {
        this.resourcesUrl = resourcesUrl;
        console.log("Created ScooterAdaptor for " + resourcesUrl);
    }

    async fetchJson(URL, options = null){
        let response = await fetch(URL,options)
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

    async asyncSave(scooter){
        console.log('ScooterAdaptor .asyncSave()...');

        let scooterReturned;

        if (scooter == null)
            scooterReturned = await this.fetchJson(this.resourcesUrl, {method: 'POST'});
        else
        scooterReturned = await this.fetchJson(this.resourcesUrl, {method: 'PUT', body: JSON.stringify(
            {scooter: scooter}), headers: {'Content-type': 'application/json; charset=UTF-8'}});

        return Scooter.copyConstructer(scooterReturned)
    }

    async asyncFindById(id){
        console.log('ScooterAdaptor .asyncFindByID()...');
        return await this.fetchJson(this.resourcesUrl + id, {method: 'GET'});
    }

    async asyncDeleteById(id){
        console.log('ScooterAdaptor .asyncDeleteByID()...');
        return await this.fetchJson(this.resourcesUrl + id, {method: 'DELETE'});
    }
}