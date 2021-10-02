package com.example.aq.ui.sere_list;

import com.example.aq.model.ComplexSereList;

public class ComplexSerePresenter implements ComplexSereContract.Presenter, ComplexSereContract.Model.OnFinishedListener {
    ComplexSereContract.Model model;
    ComplexSereContract.View view;

    public ComplexSerePresenter(ComplexSereContract.View view) {
        this.view = view;
        model = new ComplexSereCotractModel();
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void requestData() {
        model.getComplexSere(ComplexSerePresenter.this);
    }

    @Override
    public void onFinished(ComplexSereList sere) {
        view.sendDataToLog(sere);
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure(t);
    }
}
