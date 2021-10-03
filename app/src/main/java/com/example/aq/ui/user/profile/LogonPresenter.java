package com.example.aq.ui.user.profile;


import com.example.aq.model.OwnPerson;

public class LogonPresenter implements LogonContract.Presenter, LogonContract.Model.OnFinishedListener {
    LogonContract.Model model;
    LogonContract.View view;

    public LogonPresenter(LogonContract.View view) {
        this.view = view;
        model = new LogonCotractModel();
    }

    @Override
    public void onDestroy() {
        //model = null;
        view = null;

    }

    @Override
    public void onFinished(OwnPerson person) {
        view.showData(person);
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure(t);
    }

    public void updatePersonData() {
        model.updatePersonData(LogonPresenter.this);
    }
}
