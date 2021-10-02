package com.example.aq.ui.sere_list;

import com.example.aq.model.Sere;

public class SerePresenter implements SereContract.Presenter, SereContract.Model.OnFinishedListener {
    SereContract.Model model;
    SereContract.View view;

    public SerePresenter(SereContract.View view) {
        this.view = view;
        model = new SereCotractModel();
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void requestData() {
        model.getSere(SerePresenter.this);
    }

    @Override
    public void onFinished(Sere sere) {
        view.sendDataToLog(sere);
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure(t);
    }
}
