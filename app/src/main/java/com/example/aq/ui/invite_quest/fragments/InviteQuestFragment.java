package com.example.aq.ui.invite_quest.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aq.R;
import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;
import com.example.aq.ui.invite_quest.InviteQuestActivity;
import com.example.aq.ui.invite_quest.InviteQuestContract;
import com.example.aq.ui.invite_quest.InviteQuestPresenter;
import com.example.aq.util.PreferenceUtils;
import com.google.android.material.snackbar.Snackbar;

public class InviteQuestFragment extends Fragment  implements InviteQuestContract.View {
    public static final String TAG = InviteQuestFragment.class.getSimpleName();

    private EditText mEmail;
    private EditText mFirstname;
    private EditText mLastname;
    private InviteQuestPresenter mInviteQuestPresenter;

    public InviteQuestFragment() {
        super(R.layout.fragment_invite_quest);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mEmail = view.findViewById(R.id.invite_quest_email);
        mFirstname = view.findViewById(R.id.invite_quest_firstname);
        mLastname = view.findViewById(R.id.invite_quest_lastname);

        mInviteQuestPresenter = new InviteQuestPresenter(InviteQuestFragment.this);

        view.findViewById(R.id.invite_quest_send_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InviteQuest inviteQuest = new InviteQuest();
                inviteQuest.setEmail(mEmail.getText().toString());
                inviteQuest.setFirstName(mFirstname.getText().toString());
                inviteQuest.setLastName(mLastname.getText().toString());
                //inviteQuest.set(position.getText().toString());
                mInviteQuestPresenter.requestData(inviteQuest);
            }
        });
    }

    @Override
    public void showData(InviteAnswer inviteAnswer) {
        Log.wtf("RESPONSE", inviteAnswer.toString());

        if (!TextUtils.isEmpty(inviteAnswer.getInviteToken())) {
            PreferenceUtils.setToken(inviteAnswer.getInviteToken());

            // ... запрос в api с текущим токеном на получение инфы о юзере
            // получение статуса аккаунта
            // перенаправление на соответствующую активити (approved, rejected, fired)

            getActivity().getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.invite_quest_fragment, InvitePendingFragment.class, null)
                    .commit();


        } else {
            Toast.makeText(getContext(), R.string.invite_error, Toast.LENGTH_SHORT);
        }
    }


    @Override
    public void onResponseFailure(Throwable t) {
        /*Toast toast = new Toast(LaunchActivity.this);
        toast.setText("error");
        toast.show();*/
        Toast.makeText(getContext(), R.string.invite_error, Toast.LENGTH_SHORT);

        Log.wtf("ERROR", t.getMessage());
    }
}