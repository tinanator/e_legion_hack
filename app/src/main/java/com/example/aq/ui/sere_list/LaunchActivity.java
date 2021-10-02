package com.example.aq.ui.sere_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.aq.R;
import com.example.aq.model.ComplexSereList;

public class LaunchActivity extends AppCompatActivity implements ComplexSereContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        ComplexSerePresenter sereListPresenter = new ComplexSerePresenter(this);
        sereListPresenter.requestData();
 /*       SerePresenter serePresenter = new SerePresenter(this);
        serePresenter.requestData();*/
    }

    @Override
    public void sendDataToLog(ComplexSereList complexSere) {
        Log.wtf("Complex", complexSere.toString());
        Log.wtf("Complex Status", complexSere.getStatus());
    }

    @Override
    public void onResponseFailure(Throwable t) {
        /*Toast toast = new Toast(LaunchActivity.this);
        toast.setText("error");
        toast.show();*/
        Log.wtf("ERROR", t.getMessage());
    }
}