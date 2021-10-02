package com.example.aq.ui.sere_list;

import com.example.aq.model.Sere;

import java.util.List;

public interface SereListContract {
    public interface Model {
        public interface OnFinishedListener {
            void onFinished(List<Sere> sereList);
            void onFailure(Throwable t);
        }

        void getSereList(OnFinishedListener onFinishedListener);
    }

    public interface View {
//        void showProgress();
//        void hideProgress();

        void setSereList(List<Sere> sereList);
        void onResponseFailure(Throwable t);

    }

    public interface Presenter {
        void onDestroy();
        void requestData();
    }
}
