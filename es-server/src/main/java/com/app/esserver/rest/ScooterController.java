package com.app.esserver.rest;

import com.app.esserver.models.Scooter;
import com.app.esserver.repositories.ScooterRepositoryMock;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/scooters")
public class ScooterController {
    private ScooterRepositoryMock scooterRepo = new ScooterRepositoryMock();

    @GetMapping("/")
    public List<Scooter> findAll() {
        return scooterRepo.findAll();
    }

    @GetMapping("/{id}")
    public Scooter findById(@PathVariable long id) {
        return scooterRepo.findById(id);
    }

//    @PostMapping("/")
    @PutMapping("/")
    @ResponseBody
    public Scooter saveScooter(@RequestBody Scooter scooter){
        Scooter saveScooter = scooterRepo.save(scooter);

        return saveScooter;

//        //Created
//        // /user/{id}  savedUser.getId()
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(saveScooter.getId()).toUri();
//
//        ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public Scooter deleteById(@PathVariable long id) {
        return scooterRepo.deleteById(id);
    }
}
