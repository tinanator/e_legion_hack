package com.example.aq.ui.admin.fragments.pending;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aq.R;
import com.example.aq.model.AdminApproved;
import com.example.aq.model.AdminApprovedAnswer;
import com.example.aq.model.OtherPerson;
import com.example.aq.network.RetrofitClientInstance;
import com.example.aq.network.RetrofitClientInterface;
import com.example.aq.ui.admin.fragments.pending.adapter.AdminPendingAdapter;
import com.example.aq.ui.user.profile.adapter.LogonAchievementsAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminPendingFragment extends Fragment {

    RecyclerView mRecyclerView;
    private RetrofitClientInterface mApiService;

    public AdminPendingFragment() {
        super(R.layout.fragment_admin_pending);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.admin_pending_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setAdapter(new AdminPendingAdapter());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(10);

        mApiService = RetrofitClientInstance.getInstance().create(RetrofitClientInterface.class);
        Call<AdminApprovedAnswer> call = mApiService.sendApproved(new AdminApproved());


   /*     Call<AdminApprovedAnswer> call = mApiService.sendApproved(new AdminApproved());

        call.enqueue(new Callback<AdminApprovedAnswer>() {
            @Override
            public void onResponse(Call<AdminApprovedAnswer> call, Response<AdminApprovedAnswer> response) {
                //Log.wtf(TAG, response.raw().toString());

                onFinishedListener.onSendPendingFinished(response.body());
            }

            @Override
            public void onFailure(Call<AdminApprovedAnswer> call, Throwable t) {
                onFinishedListener.onSendPendingFailure(t);
            }
        });  */  }

}
