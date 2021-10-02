package com.example.aq.ui.launch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aq.R;

import android.util.Log;

import com.example.aq.R;
import com.example.aq.ui.admin.AdminActivity;
import com.example.aq.ui.invite_quest.InviteQuestActivity;
import com.example.aq.ui.sere_list.ComplexSereCotractModel;
import com.example.aq.util.PreferenceUtils;

public class LaunchActivity extends AppCompatActivity{
    public static final String TAG = LaunchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        init();
    }

    private void init() {
        PreferenceUtils.setToken("");
        String token = PreferenceUtils.getToken();
        //Log.wtf(TAG,  " before set " + token);
        if (!TextUtils.isEmpty(token)) { // токен в локальном хранилище уже есть
            // ... запрос в api с текущим токеном на получение инфы о юзере
            // получение статуса аккаунта
            // перенаправление на соответствующую активити (approved, rejected, fired)
        }
        else {
            Intent intent = new Intent(this, AdminActivity.class);
            //EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
            //String message = editText.getText().toString();
            //intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);


/*
            // токена нет, значит мы его не получали либо был сбой.
            // переходим на активити 'форму подачи заявки' (InviteQuestActivity)
            Intent intent = new Intent(this, InviteQuestActivity.class);
            //EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
            //String message = editText.getText().toString();
            //intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);*/

            ///PreferenceUtils.setToken("hello ");
            ///Log.wtf(TAG,   "after set " + PreferenceUtils.getToken());

        }
    }
}