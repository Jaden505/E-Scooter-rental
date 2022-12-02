package com.app.esserver.models;

import com.app.esserver.repositories.Identifable;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Entity
@Table(name="TRIP")
@NamedQuery(name = "select_all_trips", query = "select t from Trip t")
public class Trip implements Identifable {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="scooterId", nullable = false)
    private Scooter scooterId;

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
}
