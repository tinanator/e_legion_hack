package com.example.aq.ui.sere_list;

import com.example.aq.model.Sere;

public interface SereContract {
    interface Model {
        interface OnFinishedListener {
            void onFinished (Sere sere);
            void onFailure(Throwable t);
        }

        void getSere(OnFinishedListener onFinishedListener);
    }
    interface View {
        void sendDataToLog(Sere sere);
        void onResponseFailure(Throwable t);
    }
    interface Presenter {
        void onDestroy();
        void requestData();
    }
}
