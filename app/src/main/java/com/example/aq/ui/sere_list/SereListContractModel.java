package com.example.aq.ui.sere_list;

import android.util.Log;

import com.example.aq.model.Sere;
import com.example.aq.network.RetrofitClientInstance;
import com.example.aq.network.RetrofitClientInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SereListContractModel implements SereListContract.Model {

    public static final String TAG = SereListContractModel.class.getSimpleName();

    @Override
    public void getSereList(OnFinishedListener onFinishedListener) {
        RetrofitClientInterface apiService = RetrofitClientInstance.getInstance().create(RetrofitClientInterface.class);
        Call<List<Sere>> call = apiService.getSereList();
        call.enqueue(new Callback<List<Sere>>() {
            @Override
            public void onResponse(Call<List<Sere>> call, Response<List<Sere>> response) {
                List<Sere> sereList = response.body();
                Log.d(TAG, "Number of movies received: " + sereList.size());
                onFinishedListener.onFinished(sereList);
            }

            @Override
            public void onFailure(Call<List<Sere>> call, Throwable t) {
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}
