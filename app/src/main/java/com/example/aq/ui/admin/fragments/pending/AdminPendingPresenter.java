package com.example.aq.ui.admin.fragments.pending;


import com.example.aq.model.InviteQuest;
import com.example.aq.model.OwnPerson;
import com.example.aq.ui.admin.fragments.pending.AdminPedingCotract;

public class AdminPendingPresenter implements AdminPedingCotract.Presenter, AdminPedingCotract.Model.InsertOnFinishedListener, AdminPedingCotract.Model.UpdateOnFinishedListener {
    AdminPedingCotract.Model model;
    AdminPedingCotract.View view;

    public AdminPendingPresenter(AdminPedingCotractModel.View view) {
        this.view = view;
        this.model = new AdminPedingCotractModel();
    }

    @Override
    public void onDestroy() {
        view = null;
        //model = null;
    }

/*
    @Override
    public void requestData(InviteQuest inviteQuest) {
        model.sendInviteQuest(inviteQuest, AdminPendingPresenter.this);
    }

    @Override
    public void onInsertFinished(OwnPerson person) {
        view.showInsertData(person);
    }

    @Override
    public void onInsertFailure(Throwable t) {
        view.onIsertResponseFailure(t);
    }

    public void updatePersonData() {
        model.updatePersonData(AdminPendingPresenter.this);
    }

    @Override
    public void onUpdateFinished(OwnPerson person) {
        view.showUpdateData(person);
    }

    @Override
    public void onUpdateFailure(Throwable t) {
        view.onUpdateResponseFailure(t);
    }*/
    
    
    
}
