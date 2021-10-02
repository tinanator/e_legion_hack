package com.example.aq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InviteQuest implements Serializable {
    @SerializedName("email")
    String email;

    @SerializedName("firstname")
    String firstName;

    @SerializedName("lastname")
    String lastName;
/*
    @SerializedName("birthday")
    String birthDay;

    @SerializedName("position_id")
    int positionId;*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "InviteQuest{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
