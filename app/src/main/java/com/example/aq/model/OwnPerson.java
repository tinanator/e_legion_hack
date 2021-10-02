package com.example.aq.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OwnPerson extends Person implements Serializable {

    @SerializedName("invite_token")
    @Expose
    String inviteToken;

    public String getInviteToken() {
        return inviteToken;
    }

    public void setInviteToken(String inviteToken) {
        this.inviteToken = inviteToken;
    }

    @Override
    public String toString() {
        return "OwnPerson{" +
                "inviteToken='" + inviteToken + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", positionId='" + positionId + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", currentPostiton=" + currentPostiton +
                ", nextPosition=" + nextPosition +
                ", achievements=" + toAchievementsString(achievements) +
                ", bonuses=" + bonuses +
                ", admin=" + admin +
                ", createStamp=" + createStamp +
                '}';
    }
}
