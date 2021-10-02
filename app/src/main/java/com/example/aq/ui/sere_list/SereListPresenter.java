package com.example.aq.ui.sere_list;

import com.example.aq.model.Sere;

import java.util.List;

public class SereListPresenter implements SereListContract.Presenter, SereListContract.Model.OnFinishedListener {

    SereListContract.Model model;
    SereListContract.View view;

    public SereListPresenter(SereListContract.View view) {
        this.model = new SereListContractModel();
        this.view = view;
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void requestData() {
        model.getSereList(this);
    }

    @Override
    public void onFinished(List<Sere> sereList) {
        view.setSereList(sereList);
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure(t);
    }
}
