package com.example.aq.ui.admin.fragments.pending;

import com.example.aq.model.AdminApproved;
import com.example.aq.model.AdminApprovedAnswer;
import com.example.aq.model.OtherPerson;

public interface AdminPendingContract {
    public interface Model {

        public interface OnSendPendingFinishedListener {
            void onSendPendingFinished(AdminApprovedAnswer answer);
            void onSendPendingFailure(Throwable t);
        }

        public interface OnGetListFinishedListener {
            void onGetListFinished(OtherPerson person);
            void onGetListFailure(Throwable t);
        }

        void sendPending(AdminApproved approved, OnSendPendingFinishedListener onFinishedListener);
        void getListPendingData(OnGetListFinishedListener onFinishedListener);
    }
    public interface View {
        void showPendingMessage(AdminApprovedAnswer answer);
        void onPendingMessageResponseFailure(Throwable t);

        void showPendingList(OtherPerson person);
        void onPendingListResponseFailure(Throwable t);
    }
    public interface Presenter {
        void onDestroy();
        void getPendingData();
        void requestData(AdminApproved inviteQuest);
    }
}
