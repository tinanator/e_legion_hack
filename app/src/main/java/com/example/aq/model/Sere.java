package com.example.aq.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sere implements Serializable {

    @SerializedName("id")
    @Expose(serialize = true)
    private int id;

    @SerializedName("body")
    @Expose(serialize = true)
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Sere{" +
                "id=" + id +
                ", body='" + body + '\'' +
                '}';
    }
}
