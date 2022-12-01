package com.app.esserver;

import com.app.esserver.models.Scooter;
import com.app.esserver.repositories.ScooterRepository;
import com.app.esserver.repositories.ScooterRepositoryMock;
import com.app.esserver.repositories.ScootersRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
        createSample();
    }

    @Autowired
    private ScooterRepository scootersRepo = new ScootersRepositoryJpa();
    private void createSample(){
        List<Scooter> scooters = this. scootersRepo.findAll();
        if (scooters.size() > 0) return;
        for (int i = 0; i < 10; i++) {
            Scooter newScooter = Scooter.creatSampleScooter(i);
            this.scootersRepo.save(newScooter);
        }
    }
}
