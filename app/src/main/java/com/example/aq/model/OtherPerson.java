package com.example.aq.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OtherPerson implements Serializable {
    @SerializedName("id")
    @Expose
    int id;

    String email;
    String firstname;
    String lastname;
    String birthday;

    @SerializedName("position_id")
    @Expose
    String positionId;

    @SerializedName("account_status")
    @Expose
    String accountStatus;


    int bonuses;
    int admin;

    @SerializedName("create_stamp")
    int createStamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getBonuses() {
        return bonuses;
    }

    public void setBonuses(int bonuses) {
        this.bonuses = bonuses;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getCreateStamp() {
        return createStamp;
    }

    public void setCreateStamp(int createStamp) {
        this.createStamp = createStamp;
    }

    @Override
    public String toString() {
        return "OtherPerson{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", positionId='" + positionId + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", bonuses=" + bonuses +
                ", admin=" + admin +
                ", createStamp=" + createStamp +
                '}';
    }
}
