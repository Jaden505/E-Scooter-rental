package com.app.esserver;

import com.app.esserver.models.Scooter;
import com.app.esserver.models.Trip;
import com.app.esserver.repositories.ScootersRepositoryJpa;
import com.app.esserver.repositories.TripRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class EsServerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(EsServerApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedHeaders("*");
            }
        };
    }

    @Override
    public void run(String... args) throws Exception {
        createSamples();
    }

    @Autowired
    private ScootersRepositoryJpa scootersRepo = new ScootersRepositoryJpa();

    @Autowired
    private TripRepositoryJpa tripRepo = new TripRepositoryJpa();

    private void createSamples(){
        List<Scooter> scooters = this.scootersRepo.findAll();
        List<Trip> trips = this.tripRepo.findAll();

        if (scooters.size() > 0 || trips.size() > 0) return;

        for (int i = 1; i < 20; i++) {
            Scooter scooter = Scooter.creatSampleScooter(i);
            Trip trip = Trip.creatSampleTrip(300 + i, scooter);
            Trip trip2 = Trip.creatSampleTrip(900 + i, scooter);

            scooter.addTrip(trip);
            scooter.addTrip(trip2);

            this.scootersRepo.save(scooter);
            this.tripRepo.save(trip);
        }
    }
}
