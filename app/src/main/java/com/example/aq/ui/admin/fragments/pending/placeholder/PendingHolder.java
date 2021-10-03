package com.example.aq.ui.admin.fragments.pending.placeholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aq.R;
import com.example.aq.model.Achieve;
import com.example.aq.ui.admin.fragments.pending.adapter.AdminPendingAdapter;

public class PendingHolder extends RecyclerView.ViewHolder
{
    public static final String TAG = PendingHolder.class.getSimpleName();

    private final ImageView mImageView;
    private final TextView mName;
    private final TextView mNotice;
    private final TextView mBonus;

    private AdminPendingAdapter mComplexAdapter;

    public PendingHolder(View itemView) {
        super(itemView);

        mImageView = itemView.findViewById(R.id.kitten_gif_view);
        mName = itemView.findViewById(R.id.logon_achievement_name);
        mNotice = itemView.findViewById(R.id.logon_achievement_notice);
        mBonus = itemView.findViewById(R.id.logon_achievement_bonus);

        itemView.findViewById(R.id.kitten_gif_view).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                mComplexAdapter.removeItem(getAdapterPosition());
            }
        });
    }

    public void bind(Achieve model)
    {
//        Log.i(TAG, "bind: " + getAdapterPosition());

        mName.setText(model.getName());
        mBonus.setText(String.valueOf(model.getBonus()));
        mNotice.setText(model.getNotice());

    }

    public PendingHolder builder(AdminPendingAdapter adapter)
    {
        mComplexAdapter = adapter;
        return this;
    }

}
