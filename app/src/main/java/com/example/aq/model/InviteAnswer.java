package com.example.aq.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InviteAnswer implements Serializable {
    @SerializedName("account_status")
    @Expose
    private String accountStatus;

    @SerializedName("invite_token")
    @Expose
    private String inviteToken;

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getInviteToken() {
        return inviteToken;
    }

    public void setInviteToken(String inviteToken) {
        this.inviteToken = inviteToken;
    }

    @Override
    public String toString() {
        return "InviteAnswer{" +
                "accountStatus='" + accountStatus + '\'' +
                ", inviteToken='" + inviteToken + '\'' +
                '}';
    }
}
