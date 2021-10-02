package com.example.aq.ui.admin;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.aq.R;
import com.example.aq.ui.admin.fragments.AdminAllFragment;
import com.example.aq.ui.admin.fragments.AdminFragment;
import com.example.aq.ui.admin.fragments.AdminPendingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;


public class AdminActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin);


        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.admin_fragments, AdminFragment.class, null)
                .commit();

        FragmentContainerView fragmentContainerView = findViewById(R.id.admin_fragments);
        getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragments, AdminFragment.class, null).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.admin_bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.admin_nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragments, AdminFragment.class, null).commit();
                        break;
                    case R.id.admin_nav_pending:
                        getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragments, AdminPendingFragment.class, null).commit();
                        break;
                    case R.id.admin_nav_all:
                        getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragments, AdminAllFragment.class, null).commit();
                        break;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.admin_nav_home);


    }

    private void setFragment(int id, Class cl) {
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(id, cl, null)
                .commit();
    }

}