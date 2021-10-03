package com.example.aq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AdminApproved implements Serializable {
    @SerializedName("user_id")
    int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AdminApproved{" +
                "userId=" + userId +
                '}';
    }
}
