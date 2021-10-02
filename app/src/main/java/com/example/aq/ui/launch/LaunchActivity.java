package com.example.aq.ui.launch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aq.R;

import com.example.aq.model.OwnPerson;
import com.example.aq.ui.invite_quest.InviteQuestActivity;
import com.example.aq.ui.invite_quest.InviteQuestContract;
import com.example.aq.ui.invite_quest.InviteQuestPresenter;
import com.example.aq.util.PreferenceUtils;

public class LaunchActivity extends AppCompatActivity  implements LaunchContract.View {
    public static final String TAG = LaunchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        init();

        findViewById(R.id.launch_frame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });
    }

    private void init() {
        //PreferenceUtils.setToken("");
        String token = PreferenceUtils.getToken();
        //Log.wtf(TAG,  " before set " + token);
        if (!TextUtils.isEmpty(token)) { // токен в локальном хранилище уже есть
            // ... запрос в api с текущим токеном на получение инфы о юзере
            // получение статуса аккаунта
            // перенаправление на соответствующую активити (approved, rejected, fired)
            new LaunchPresenter(LaunchActivity.this).updatePersonData();

        }
        else {
/*            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);*/



            // токена нет, значит мы его не получали либо был сбой.
            // переходим на активити 'форму подачи заявки' (InviteQuestActivity)
            Intent intent = new Intent(this, InviteQuestActivity.class);
            //EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
            //String message = editText.getText().toString();
            //intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);

            ///PreferenceUtils.setToken("hello ");
            ///Log.wtf(TAG,   "after set " + PreferenceUtils.getToken());

        }
    }

    @Override
    public void showData(OwnPerson person) {

        Intent intent = new Intent(this, InviteQuestActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onResponseFailure(Throwable t) {

    }
}