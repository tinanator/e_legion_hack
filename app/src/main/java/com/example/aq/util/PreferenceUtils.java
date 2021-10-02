package com.example.aq.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {
    public static final String APP_PREFERENCES_MAME = "";
    private static SharedPreferences sSharedPreferences;

    public PreferenceUtils(Context context) {
       sSharedPreferences = context.getSharedPreferences(APP_PREFERENCES_MAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getInstance() {
        return  sSharedPreferences;
    }

    public static String getToken() {
        return sSharedPreferences.getString("invite_token", "");
    }

    public static void setToken(String token) {
        sSharedPreferences.edit().putString("invite_token", token).commit();
    }

    public static void isWelcomeShowed(boolean b) {
        sSharedPreferences.edit().putBoolean("welcome", b).commit();
    }

    public static boolean isWelcomeShowed() {
        return sSharedPreferences.getBoolean("welcome", false);
    }

    public static void isAdmin(boolean b) {
        sSharedPreferences.edit().putBoolean("admin", b).commit();
    }

    public static boolean isAdmin() {
        return sSharedPreferences.getBoolean("admin", false);
    }
}
