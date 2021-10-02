package com.example.aq.ui.sere_list;

import com.example.aq.model.ComplexSereList;

public interface ComplexSereContract {
    interface Model {
        interface OnFinishedListener {
            void onFinished (ComplexSereList complexSere);
            void onFailure(Throwable t);
        }

        void getComplexSere(OnFinishedListener onFinishedListener);
    }
    interface View {
        void sendDataToLog(ComplexSereList complexSere);
        void onResponseFailure(Throwable t);
    }
    interface Presenter {
        void onDestroy();
        void requestData();
    }
}
