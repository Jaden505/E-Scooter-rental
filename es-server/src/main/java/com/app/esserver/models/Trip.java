package com.app.esserver.models;

import com.app.esserver.repositories.Identifable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Entity
@Table(name="TRIP")
@NamedQueries({
        @NamedQuery(
                name = "select_all_trips",
                query = "select t from Trip t where t.scooter.id=?1"
        ),
        @NamedQuery(
                name = "Trip_find_by_scooterId_and_period",
                query = "select t from Trip t where t.scooter.id=?1 and t.startDate=?2 and t.endDate=?3"
        )
})
public class Trip implements Identifable {
    @Id
    @GeneratedValue
    private long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="scooter", nullable = false)
    private Scooter scooter;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String startPosition;
    private String endPosition;
    private double mileage;
    private double cost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Scooter getScooter() {
        return scooter;
    }

    public void setScooter(Scooter scooter) {
        this.scooter = scooter;
    }
}

