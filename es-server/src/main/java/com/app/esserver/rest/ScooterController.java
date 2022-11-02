package com.app.esserver.rest;

import com.app.esserver.models.Scooter;
import com.app.esserver.repositories.ScooterRepositoryMock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ScooterController {
    private ScooterRepositoryMock scooterRepo = new ScooterRepositoryMock();

    @RequestMapping("/scooters/test")
    public List<Scooter> getTestScooter (){
        return scooterRepo.findAll();
    }
}
