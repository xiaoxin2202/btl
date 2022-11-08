package com.example.demobtl.model;

import java.io.Serializable;

public class Player implements Serializable {
    private int ID;
    private String name,country;
    private float elo;

    public Player() {
    }

    public Player(int ID, String name, String country, float elo) {
        this.ID = ID;
        this.name = name;
        this.country = country;
        this.elo = elo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getElo() {
        return elo;
    }

    public void setElo(float elo) {
        this.elo = elo;
    }
}
