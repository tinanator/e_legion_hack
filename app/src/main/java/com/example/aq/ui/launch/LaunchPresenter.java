package com.example.aq.ui.launch;


import com.example.aq.model.InviteQuest;
import com.example.aq.model.OwnPerson;
import com.example.aq.network.RetrofitClientInstance;

public class LaunchPresenter implements LaunchContract.Presenter, LaunchContract.Model.OnFinishedListener {
    LaunchContract.Model model;
    LaunchContract.View view;

    public LaunchPresenter(LaunchContract.View view) {
        this.view = view;
        model = new LaunchCotractModel();
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
        model.updatePersonData(LaunchPresenter.this);
    }
}
