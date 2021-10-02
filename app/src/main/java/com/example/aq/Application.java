package com.example.aq;

import com.example.aq.util.PreferenceUtils;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        new PreferenceUtils(Application.this);
    }
}
