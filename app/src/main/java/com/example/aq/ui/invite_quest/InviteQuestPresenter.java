package com.example.aq.ui.invite_quest;


import com.example.aq.model.InviteQuest;
import com.example.aq.model.OwnPerson;

public class InviteQuestPresenter implements InviteQuestContract.Presenter, InviteQuestContract.Model.InsertOnFinishedListener, InviteQuestContract.Model.UpdateOnFinishedListener {
    InviteQuestContract.Model model;
    InviteQuestContract.View view;

    public InviteQuestPresenter(InviteQuestContract.View view) {
        this.view = view;
        model = new InviteQuestCotractModel();
    }

    @Override
    public void onDestroy() {
        view = null;
        //model = null;
    }

    @Override
    public void requestData(InviteQuest inviteQuest) {
        model.sendInviteQuest(inviteQuest, InviteQuestPresenter.this);
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
        model.updatePersonData(InviteQuestPresenter.this);
    }

    @Override
    public void onUpdateFinished(OwnPerson person) {
        view.showUpdateData(person);
    }

    @Override
    public void onUpdateFailure(Throwable t) {
        view.onUpdateResponseFailure(t);
    }
}
