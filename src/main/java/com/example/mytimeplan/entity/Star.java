package com.example.mytimeplan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Star {

    @Id
    @GeneratedValue
    private String name;
    private long distance;

    public Star() {
    }

    public Star(String name, long distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
}

