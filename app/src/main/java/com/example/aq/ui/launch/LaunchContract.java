package com.example.aq.ui.launch;

import com.example.aq.model.InviteQuest;
import com.example.aq.model.OwnPerson;

public interface LaunchContract {
    interface Model {

        interface OnFinishedListener {
            void onFinished (OwnPerson person);
            void onFailure(Throwable t);
        }
        void updatePersonData(OnFinishedListener onFinishedListener);
    }
    interface View {
        void showData(OwnPerson person);
        void onResponseFailure(Throwable t);
    }
    interface Presenter {
        void onDestroy();
        void updatePersonData();
    }
}
