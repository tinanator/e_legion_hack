package com.example.aq;

import com.example.aq.network.RetrofitClientInstance;
import com.example.aq.network.RetrofitClientInterface;
import com.example.aq.util.PreferenceUtils;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        new PreferenceUtils(Application.this);

        //RetrofitClientInstance.getInstance().create(RetrofitClientInterface.class);
    }
}
