package com.example.aq.ui.invite_quest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aq.R;
import com.example.aq.model.InviteQuest;
import com.example.aq.model.OwnPerson;
import com.example.aq.ui.user.profile.LogonActivity;
import com.example.aq.util.PreferenceUtils;

import java.util.Timer;
import java.util.TimerTask;

public class InviteQuestActivity extends AppCompatActivity implements InviteQuestContract.View {
    public static final String TAG = InviteQuestActivity.class.getSimpleName();

    private EditText mEmail;
    private EditText mFirstname;
    private EditText mLastname;
    private com.example.aq.ui.invite_quest.InviteQuestPresenter mInviteQuestPresenter;
    private TextView mTeleType;
    private View mMainContainer;
    private View mTypeContainer;
    private Timer mTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_quest);
        mMainContainer = findViewById(R.id.invite_quest_container);
        mTypeContainer = findViewById(R.id.invite_type_container);

        mTeleType = findViewById(R.id.invite_teletype);
        mEmail = findViewById(R.id.invite_quest_email);
        mFirstname = findViewById(R.id.invite_quest_firstname);
        mLastname = findViewById(R.id.invite_quest_lastname);

        mInviteQuestPresenter = new com.example.aq.ui.invite_quest.InviteQuestPresenter(InviteQuestActivity.this);
            mTimer = new Timer();
                    mTimer.scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){
                    if(mInviteQuestPresenter != null)
                        if(!TextUtils.isEmpty(PreferenceUtils.getToken()))
                            mInviteQuestPresenter.updatePersonData();
                }
            },0,7000);
        findViewById(R.id.invite_quest_send_button).setOnClickListener(new View.OnClickListener() {
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
    public void showInsertData(OwnPerson person) {
        Log.wtf("RESPONSE", person.toString());

        if (!TextUtils.isEmpty(person.getInviteToken())) {
            PreferenceUtils.setToken(person.getInviteToken());
            //mInviteQuestPresenter.updatePersonData();

            // ... запрос в api с текущим токеном на получение инфы о юзере (а вдруг изменился)
            // получение статуса аккаунта
            // перенаправление на соответствующую активити (approved, rejected, fired)
            showTeleType(person.getAccountStatus());
  /*          new Timer().scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){
                        mInviteQuestPresenter.updatePersonData();
                }
            },0,100);*/
        } else {
            Toast.makeText(InviteQuestActivity.this, R.string.invite_error, Toast.LENGTH_SHORT);
        }
    }


    @Override
    public void onIsertResponseFailure(Throwable t) {

        Toast.makeText(InviteQuestActivity.this, R.string.invite_error, Toast.LENGTH_SHORT);

        Log.wtf("ERROR", t.getMessage());
    }

    @Override
    public void showUpdateData(OwnPerson person) {
        showTeleType(person.getAccountStatus());
    }

    @Override
    public void onUpdateResponseFailure(Throwable t) {
        Toast.makeText(InviteQuestActivity.this, R.string.invite_error, Toast.LENGTH_SHORT);

    }

    private void hideTeletype() {
        mMainContainer.setVisibility(View.VISIBLE);
        mTypeContainer.setVisibility(View.GONE);
    }

    private void showTeleType(String accountStatus) {
        switch (accountStatus) {
            case "approved":
                mTeleType.setText(R.string.invite_approved);
                if(!PreferenceUtils.isWelcomeShowed()) {
                    PreferenceUtils.isWelcomeShowed(true);
                    setResult(0);
                    Intent intent = new Intent(InviteQuestActivity.this, LogonActivity.class);
                    startActivity(intent);
                    //mInviteQuestPresenter.onDestroy();
   /*
                    mTeleType.postDelayed(new Runnable() {
                                              @Override
                                              public void run() {
                                                  if(PreferenceUtils.isWelcomeShowed()) return;

                                                  Toast.makeText(InviteQuestActivity.this, "Go to Profile!", Toast.LENGTH_SHORT).show();


                                              }
                                          }
                            , 7000);*/
                    finish();
                } else {
                    setResult(0);
                    Intent intent = new Intent(InviteQuestActivity.this, LogonActivity.class);
                    startActivity(intent);
                    Toast.makeText(InviteQuestActivity.this, "Go to Profile!", Toast.LENGTH_SHORT).show();
                    mInviteQuestPresenter.onDestroy();
                    finish();

                }
                break;

            case "rejected":
                mTeleType.setText(R.string.invite_rejected);
                break;

            case "fired":
                mTeleType.setText(R.string.invite_fired);
                break;

            default:
                mTeleType.setText(R.string.invite_pending);
                break;

        }
        mMainContainer.setVisibility(View.GONE);
        mTypeContainer.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
        mInviteQuestPresenter.onDestroy();
    }
}