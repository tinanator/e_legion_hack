package com.example.aq.ui.admin.fragments.pending;

import android.util.Log;

import com.example.aq.model.AdminApproved;
import com.example.aq.model.AdminApprovedAnswer;
import com.example.aq.model.InviteQuest;
import com.example.aq.model.OtherPerson;
import com.example.aq.model.OwnPerson;
import com.example.aq.network.RetrofitClientInstance;
import com.example.aq.network.RetrofitClientInterface;
import com.example.aq.util.PersonSettings;
import com.example.aq.util.PreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminPedingCotractModel implements AdminPendingContract.Model {
    public static final String TAG = AdminPedingCotractModel.class.getSimpleName();
    RetrofitClientInterface mApiService;
    public AdminPedingCotractModel() {
        mApiService = RetrofitClientInstance.getInstance().create(RetrofitClientInterface.class);
    }


    @Override
    public void sendPending(AdminApproved approved, OnSendPendingFinishedListener onFinishedListener) {

        Call<AdminApprovedAnswer> call = mApiService.sendApproved(approved);

        call.enqueue(new Callback<AdminApprovedAnswer>() {
            @Override
            public void onResponse(Call<AdminApprovedAnswer> call, Response<AdminApprovedAnswer> response) {
                //Log.wtf(TAG, response.raw().toString());

                onFinishedListener.onSendPendingFinished(response.body());
            }

            @Override
            public void onFailure(Call<AdminApprovedAnswer> call, Throwable t) {
                onFinishedListener.onSendPendingFailure(t);
            }
        });
    }
    @Override
        public void getListPendingData(OnGetListFinishedListener onFinishedListener) {

            Call<OtherPerson> call = mApiService.getAllPendingList(PreferenceUtils.getToken());

            call.enqueue(new Callback<OtherPerson>() {
                @Override
                public void onResponse(Call<OtherPerson> call, Response<OtherPerson> response) {
                    Log.wtf(TAG, "UPDATE:" +response.raw().toString());

                    onFinishedListener.onGetListFinished(response.body());
                }

                @Override
                public void onFailure(Call<OtherPerson> call, Throwable t) {
                    onFinishedListener.onGetListFailure(t);
                }
            });
    }
}
