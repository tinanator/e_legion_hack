package com.example.aq.model;

public class Position {
    int id;
    String name;
    int active;
    int amout;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    @Override
    public String toString() {
        return "CurrentPosition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", amout=" + amout +
                '}';
    }
}
