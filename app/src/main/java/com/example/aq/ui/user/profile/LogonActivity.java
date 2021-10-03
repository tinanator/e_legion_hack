package com.example.aq.ui.user.profile;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aq.R;
import com.example.aq.model.OwnPerson;
import com.example.aq.ui.admin.AdminActivity;
import com.example.aq.ui.user.calendar.CalendarActivity;
import com.example.aq.ui.user.profile.adapter.LogonAchievementsAdapter;
import com.example.aq.util.PersonSettings;
import com.google.android.material.navigation.NavigationView;

public class LogonActivity extends AppCompatActivity implements LogonContract.View {

    private ImageView mAvatar;
    private TextView mName;
    private TextView mBirthday;
    private RecyclerView mRecyclerView;
    private TextView mPositionColored;
    private TextView mPosition;
    private TextView mBonusCount;
    private TextView mAchieveStatus;
//    private TextView mProfileBirthday;
    private TextView mEmail;
//    private TextView mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setResult(0);
        NavigationView view = findViewById(R.id.logon_nav_view);
        if(PersonSettings.getPerson().getAdmin() == 1) {
            view.getMenu().findItem(R.id.logon_side_item_calendar).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if(menuItem.getItemId() == R.id.logon_side_item_calendar) {
                        Intent intent = new Intent(LogonActivity.this, CalendarActivity.class);
                        startActivity(intent);
                    }
                    return false;
                }
            });

            view.getMenu().findItem(R.id.logon_side_item_admin).setVisible(true);
            view.getMenu().findItem(R.id.logon_side_item_admin).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if(menuItem.getItemId() == R.id.logon_side_item_admin) {
                        Intent intent = new Intent(LogonActivity.this, AdminActivity.class);
                        startActivity(intent);
                    }
                    return false;
                }
            });
        }
        //view.getMenu().findItem(R.id.logout).setVisible(true);
/*
        NavController navController;
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setDrawerLayout(drawerLayout)
                        .build();
*/

        //finish();
        mAvatar = findViewById(R.id.avatar);
        mName = findViewById(R.id.profile_name);
        mBirthday = findViewById(R.id.profile_birthday);
        mPositionColored = findViewById(R.id.position_colored);
        mPosition = findViewById(R.id.profile_position);
        mBonusCount = findViewById(R.id.bonus_count);
        mAchieveStatus = findViewById(R.id.achieve_status);
        mEmail = findViewById(R.id.profile_email);


        mRecyclerView = findViewById(R.id.logon_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new LogonAchievementsAdapter());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(10);

        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        // Handle the returned Uri
                        mAvatar.setImageURI(uri);
                    }
                });

        mAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });

        init();
    }

    private void init() {
        OwnPerson person = PersonSettings.getPerson();
        mName.setText(person.getFirstname() + " " + person.getLastname());
        mBirthday.setText(person.getBirthday());
        mPositionColored.setText(person.getCurrentPostiton().getName());
        mPosition.setText(person.getCurrentPostiton().getName());
        mBonusCount.setText(String.valueOf(person.getBonuses()) + " / " + String.valueOf(person.getCurrentPostiton().getAmount()));
        mAchieveStatus.setText(person.getCurrentPostiton().getName());
        mEmail.setText(person.getEmail());
        //mBirthday.setText();
    }

    @Override
    public void showData(OwnPerson person) {

    }

    @Override
    public void onResponseFailure(Throwable t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}