package com.example.aq.ui.user.profile.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aq.R;
import com.example.aq.model.Achieve;
import com.example.aq.ui.user.profile.placeholder.AchieveHolder;
import com.example.aq.util.PersonSettings;

import java.util.List;

public class LogonAchievementsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public static final String TAG = LogonAchievementsAdapter.class.getSimpleName();


    private final List<Achieve> mHolderList = PersonSettings.getPerson().getAchievements();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new AchieveHolder(
                inflater.inflate(R.layout.li_achieve, parent, false)
        ).builder(this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

                AchieveHolder achieveHolder = (AchieveHolder) holder;
                achieveHolder.bind(mHolderList.get(position));
    }

    @Override
    public int getItemCount() {
        return mHolderList.size();
    }

    @Override
    public int getItemViewType(int position) {


        return -1;
    }

    public void addItem(Achieve achieve)
    {
        mHolderList.add(achieve);
        notifyItemInserted(mHolderList.size()-1);
    }

    public void removeItem(int position)
    {
        if(mHolderList.isEmpty() || position < 0)
        {
            return;
        }

        mHolderList.remove(position);
        notifyItemRemoved(position);
    }
}
