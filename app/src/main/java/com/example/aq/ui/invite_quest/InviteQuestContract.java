package com.example.aq.ui.invite_quest;

import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;
import com.example.aq.model.OwnPerson;
import com.example.aq.model.Person;
import com.example.aq.model.Sere;

public interface InviteQuestContract {
    interface Model {

        interface OnFinishedListener {
            void onFinished (OwnPerson person);
            void onFailure(Throwable t);
        }

        void sendInviteQuest(InviteQuest inviteQuest, OnFinishedListener onFinishedListener);
        void updatePersonData(OnFinishedListener onFinishedListener);
    }
    interface View {
        void showData(OwnPerson person);
        void onResponseFailure(Throwable t);
    }
    interface Presenter {
        void onDestroy();
        void updatePersonData();
        void requestData(InviteQuest inviteQuest);
    }
}
