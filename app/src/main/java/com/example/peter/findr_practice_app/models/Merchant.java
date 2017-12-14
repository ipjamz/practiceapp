package com.example.peter.findr_practice_app.models;

/**
 * Created by peter on 11/29/17.
 */

public class Merchant {

    private boolean active;
    private String businessId;
    private String businessName;
    private int findrCredits;
    private int findrPoints;
    private String id;
    private String name;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getFindrCredits() {
        return findrCredits;
    }

    public void setFindrCredits(int findrCredits) {
        this.findrCredits = findrCredits;
    }

    public int getFindrPoints() {
        return findrPoints;
    }

    public void setFindrPoints(int findrPoints) {
        this.findrPoints = findrPoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
