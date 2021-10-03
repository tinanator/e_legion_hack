package com.example.aq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AdminApprovedAnswer implements Serializable {
    @SerializedName("success")
    boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "AdminApprovedAnswer{" +
                "success=" + success +
                '}';
    }
}
