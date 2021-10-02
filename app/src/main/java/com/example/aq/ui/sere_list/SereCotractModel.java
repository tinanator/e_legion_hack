package com.example.aq.ui.sere_list;

import android.util.Log;

import com.example.aq.model.Sere;
import com.example.aq.network.RetrofitClientInstance;
import com.example.aq.network.RetrofitClientInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SereCotractModel implements SereContract.Model {
    public static final String TAG = SereCotractModel.class.getSimpleName();

    @Override
    public void getSere(OnFinishedListener onFinishedListener) {
        RetrofitClientInterface apiService = RetrofitClientInstance.getInstance().create(RetrofitClientInterface.class);
        Call<Sere> call = apiService.getSere();
        call.enqueue(new Callback<Sere>() {
            @Override
            public void onResponse(Call<Sere> call, Response<Sere> response) {
                Log.wtf(TAG, response.body().toString());
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<Sere> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
