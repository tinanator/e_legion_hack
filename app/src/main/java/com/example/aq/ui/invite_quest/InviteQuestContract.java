package com.example.aq.ui.invite_quest;

import com.example.aq.model.InviteQuest;
import com.example.aq.model.OwnPerson;

public interface InviteQuestContract {
    interface Model {

        interface InsertOnFinishedListener {
            void onInsertFinished (OwnPerson person);
            void onInsertFailure(Throwable t);
        }

        interface UpdateOnFinishedListener {
            void onUpdateFinished (OwnPerson person);
            void onUpdateFailure(Throwable t);
        }

        void sendInviteQuest(InviteQuest inviteQuest, InsertOnFinishedListener onFinishedListener);
        void updatePersonData(UpdateOnFinishedListener onFinishedListener);
    }
    interface View {
        void showInsertData(OwnPerson person);
        void onIsertResponseFailure(Throwable t);
        void showUpdateData(OwnPerson person);
        void onUpdateResponseFailure(Throwable t);
    }
    interface Presenter {
        void onDestroy();
        void updatePersonData();
        void requestData(InviteQuest inviteQuest);
    }
}
