package com.example.aq.model;

import java.io.Serializable;

public class Achieve implements Serializable {
    int id;
    String name;
    String notice;
    int bonus;
    String type;

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
