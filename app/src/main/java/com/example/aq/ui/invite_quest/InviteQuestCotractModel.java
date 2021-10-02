package com.example.aq.ui.invite_quest;

import android.util.Log;

import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;
import com.example.aq.model.Sere;
import com.example.aq.network.RetrofitClientInstance;
import com.example.aq.network.RetrofitClientInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InviteQuestCotractModel implements InviteQuestContract.Model {
    public static final String TAG = InviteQuestCotractModel.class.getSimpleName();

    @Override
    public void sendInviteQuest(InviteQuest inviteQuest, OnFinishedListener onFinishedListener) {
        RetrofitClientInterface apiService = RetrofitClientInstance.getInstance().create(RetrofitClientInterface.class);

        Call<InviteAnswer> call = apiService.createInviteQuest(inviteQuest);

        call.enqueue(new Callback<InviteAnswer>() {
            @Override
            public void onResponse(Call<InviteAnswer> call, Response<InviteAnswer> response) {
                Log.wtf(TAG, response.raw().toString());
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<InviteAnswer> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }
}
