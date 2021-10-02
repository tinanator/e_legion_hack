package com.example.aq.model;

import java.io.Serializable;

public class Achieve implements Serializable {
    int id;
    String name;
    int bonus;
    String type;

    @Override
    public String toString() {
        return "Achieve{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bonus=" + bonus +
                ", type='" + type + '\'' +
                '}';
    }
}
