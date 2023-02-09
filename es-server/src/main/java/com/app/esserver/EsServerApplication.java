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

        if (scooters.size() > 0) return;
        if (trips.size() > 0) return;

        for (int i = 0; i < 10; i++) {
            Scooter scooter = Scooter.creatSampleScooter(i);
            Trip trip = Trip.creatSampleTrip(i, scooter);

            trip.setScooter(scooter);
            scooter.addTrip(trip);

            this.scootersRepo.save(scooter);
            this.tripRepo.save(trip);
        }
    }
}
