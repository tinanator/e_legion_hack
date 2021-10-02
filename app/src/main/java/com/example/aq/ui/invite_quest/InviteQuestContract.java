package com.example.aq.ui.invite_quest;

import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;
import com.example.aq.model.Sere;

public interface InviteQuestContract {
    interface Model {
        interface OnFinishedListener {
            void onFinished (InviteAnswer inviteAnswer);
            void onFailure(Throwable t);
        }

        void sendInviteQuest(InviteQuest inviteQuest, OnFinishedListener onFinishedListener);
    }
    interface View {
        void showData(InviteAnswer inviteAnswer);
        void onResponseFailure(Throwable t);
    }
    interface Presenter {
        void onDestroy();
        void requestData(InviteQuest inviteQuest);
    }
}
