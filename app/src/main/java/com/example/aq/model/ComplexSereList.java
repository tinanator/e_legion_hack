package com.example.aq.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComplexSereList implements Serializable {

    @SerializedName("test")
    @Expose
    private List<Sere> test = null;

    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Sere> getTest() {
        return test;
    }

    public void setTest(List<Sere> test) {
        this.test = test;
    }

    @NonNull
    @Override
    public String toString() {
        String result =  "SereList{" + "test=";

        for (Sere s : test) {
            result += s.toString();
        };
        result += ", status='" + status + '\'' + '}';

        return result;
    }
}
