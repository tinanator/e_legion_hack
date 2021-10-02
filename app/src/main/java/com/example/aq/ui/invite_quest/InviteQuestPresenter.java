package com.example.aq.ui.invite_quest;


import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;
import com.example.aq.model.OwnPerson;
import com.example.aq.model.Person;
import com.example.aq.util.PersonSettings;

public class InviteQuestPresenter implements InviteQuestContract.Presenter, InviteQuestContract.Model.OnFinishedListener {
    InviteQuestContract.Model model;
    InviteQuestContract.View view;

    public InviteQuestPresenter(InviteQuestContract.View view) {
        this.view = view;
        model = new InviteQuestCotractModel();
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void requestData(InviteQuest inviteQuest) {

        model.sendInviteQuest(inviteQuest, InviteQuestPresenter.this);
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
        model.updatePersonData(InviteQuestPresenter.this);
    }
}
