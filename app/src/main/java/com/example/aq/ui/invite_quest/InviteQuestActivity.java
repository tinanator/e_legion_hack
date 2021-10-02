package com.example.aq.ui.invite_quest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.aq.R;
import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;
import com.example.aq.ui.invite_quest.fragments.InviteQuestFragment;
import com.example.aq.util.PreferenceUtils;

public class InviteQuestActivity extends AppCompatActivity {
    public static final String TAG = InviteQuestActivity.class.getSimpleName();

    private EditText mEmail;
    private EditText mFirstname;
    private EditText mLastname;
    private Button mSendInviteQuestButton;
    private InviteQuestPresenter mInviteQuestPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_quest);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.invite_quest_fragment, InviteQuestFragment.class, null)
                    .commit();
        }
    }

}