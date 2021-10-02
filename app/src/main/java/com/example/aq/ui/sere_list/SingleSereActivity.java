package com.example.aq.ui.sere_list;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aq.R;
import com.example.aq.model.Sere;

public class SingleSereActivity extends AppCompatActivity implements SereContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);


        SerePresenter serePresenter = new SerePresenter(this);
        serePresenter.requestData();
    }

    @Override
    public void sendDataToLog(Sere sere) {

            Log.wtf("RESPONSE", sere.toString());

    }

    @Override
    public void onResponseFailure(Throwable t) {
        /*Toast toast = new Toast(LaunchActivity.this);
        toast.setText("error");
        toast.show();*/
        Log.wtf("ERROR", t.getMessage());
    }
}