package com.example.aq.model;

public class Position {
    int id;
    String name;
    int active;
    int amount;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CurrentPosition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", amout=" + amount +
                '}';
    }
}
