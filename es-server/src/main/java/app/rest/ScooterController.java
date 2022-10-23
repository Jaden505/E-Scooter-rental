package app.rest;

import app.models.Scooter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ScooterController {
    @GetMapping("/scooter")
    public List<Scooter> getTestScooter (){
        return List.of(
                new Scooter(0,"Test-scooter-B","null","0",0,0));
    }


}
