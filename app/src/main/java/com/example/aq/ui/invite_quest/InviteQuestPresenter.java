package com.example.aq.ui.invite_quest;


import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;

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
    public void onFinished(InviteAnswer inviteAnswer) {
        view.showData(inviteAnswer);
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure(t);
    }
}
