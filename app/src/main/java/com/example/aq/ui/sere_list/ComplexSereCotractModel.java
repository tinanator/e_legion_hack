package com.example.aq.ui.sere_list;

import android.util.Log;

import com.example.aq.model.ComplexSereList;
import com.example.aq.network.RetrofitClientInstance;
import com.example.aq.network.RetrofitClientInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComplexSereCotractModel implements ComplexSereContract.Model {
    public static final String TAG = ComplexSereCotractModel.class.getSimpleName();

    @Override
    public void getComplexSere(OnFinishedListener onFinishedListener) {
        RetrofitClientInterface apiService = RetrofitClientInstance.getInstance().create(RetrofitClientInterface.class);
        Call<ComplexSereList> call = apiService.getComplexSereList();
        call.enqueue(new Callback<ComplexSereList>() {
            @Override
            public void onResponse(Call<ComplexSereList> call, Response<ComplexSereList> response) {
                Log.wtf(TAG, response.body().toString());
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<ComplexSereList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
