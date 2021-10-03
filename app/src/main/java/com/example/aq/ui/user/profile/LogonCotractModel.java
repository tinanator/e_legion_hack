package com.example.aq.ui.user.profile;

import android.util.Log;

import com.example.aq.model.OwnPerson;
import com.example.aq.network.RetrofitClientInstance;
import com.example.aq.network.RetrofitClientInterface;
import com.example.aq.util.PersonSettings;
import com.example.aq.util.PreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogonCotractModel implements LogonContract.Model {
    public static final String TAG = LogonCotractModel.class.getSimpleName();
    RetrofitClientInterface mApiService;
    public LogonCotractModel() {
        mApiService = RetrofitClientInstance.getInstance().create(RetrofitClientInterface.class);

    }

    @Override
        public void updatePersonData(OnFinishedListener onFinishedListener) {

            Call<OwnPerson> call = mApiService.updatePersonData(PreferenceUtils.getToken());

            call.enqueue(new Callback<OwnPerson>() {
                @Override
                public void onResponse(Call<OwnPerson> call, Response<OwnPerson> response) {
                    Log.wtf(TAG, "UPDATE:" +response.raw().toString());
                    PersonSettings.setPerson(response.body());

                    onFinishedListener.onFinished(response.body());
                }

                @Override
                public void onFailure(Call<OwnPerson> call, Throwable t) {
                    onFinishedListener.onFailure(t);
                }
            });
    }
}
