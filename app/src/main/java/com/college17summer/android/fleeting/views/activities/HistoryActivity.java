package com.college17summer.android.fleeting.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.models.HistoryEntity;
import com.college17summer.android.fleeting.models.UserEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HistoryActivity extends AppCompatActivity {

    public static enum ITEM_TYPE {
        ITEM_TYPE_Left,
        ITEM_TYPE_Right
    }

    private RecyclerView mRecyclerView;
    private HistoryAdapter mHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().hide();
        init();


        UserEntity userInstance = UserEntity.getUserInstance();
        userInstance.netInstance();
    }

    private void init() {

        // for test init, you should add your data here.
        List<HistoryEntity> hislists = new ArrayList<HistoryEntity>();
        Random random = new Random();
        for (int i = 0; i < 100; i++)
        {
            HistoryEntity a = new HistoryEntity();
            a.setmVideoId(1000 + i);
            a.setProcess(100 + random.nextInt(10000));
            hislists.add(a);
        }

        mRecyclerView = (RecyclerView)findViewById(R.id.history_video_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mHistoryAdapter = new HistoryAdapter(hislists));

    }

    private class HistoryItemHolder extends RecyclerView.ViewHolder {

        public ImageView ivHistoryCover;
        public TextView tvHistoryVideoName;
        public TextView tvHistoryWatchTime;
        public TextView tvHistoryWatchProcess;

        public HistoryItemHolder(View itemView,int type) {
            super(itemView);

            if(type == ITEM_TYPE.ITEM_TYPE_Left.ordinal()) {
                ivHistoryCover = (ImageView) itemView.findViewById(R.id.hil_video_cover);
                tvHistoryVideoName = (TextView) itemView.findViewById(R.id.hil_video_name);
                tvHistoryWatchTime = (TextView) itemView.findViewById(R.id.hil_video_watch_time);
                tvHistoryWatchProcess = (TextView) itemView.findViewById(R.id.hil_video_watch_process);
            } else {
                ivHistoryCover = (ImageView) itemView.findViewById(R.id.hir_video_cover);
                tvHistoryVideoName = (TextView) itemView.findViewById(R.id.hir_video_name);
                tvHistoryWatchTime = (TextView) itemView.findViewById(R.id.hir_video_watch_time);
                tvHistoryWatchProcess = (TextView) itemView.findViewById(R.id.hir_video_watch_process);
            }
        }
    }

    private class HistoryAdapter extends RecyclerView.Adapter<HistoryItemHolder> {

        private List<HistoryEntity> mHistories;

        public HistoryAdapter(List<HistoryEntity> histories) {
            mHistories = histories;
        }

        @Override
        public HistoryItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view;
            int type;
            if(viewType == ITEM_TYPE.ITEM_TYPE_Left.ordinal()) {
                view = layoutInflater.inflate(R.layout.item_history_left, parent, false);
                type = ITEM_TYPE.ITEM_TYPE_Left.ordinal();
            } else {
                view = layoutInflater.inflate(R.layout.item_history_right, parent, false);
                type = ITEM_TYPE.ITEM_TYPE_Right.ordinal();
            }
            return new HistoryItemHolder(view,type);

        }

        @Override
        public void onBindViewHolder(HistoryItemHolder holder, int position) {

            HistoryEntity history = mHistories.get(position);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            if(position%2 == ITEM_TYPE.ITEM_TYPE_Left.ordinal()) {
                holder.ivHistoryCover.setImageDrawable(getResources().getDrawable(R.drawable.history_item_left));
            } else {
                holder.ivHistoryCover.setImageDrawable(getResources().getDrawable(R.drawable.history_item_right));
            }

            holder.tvHistoryVideoName.setText(String.valueOf(history.getmVideoId()));
            holder.tvHistoryWatchTime.setText(df.format(history.getTime()));
            holder.tvHistoryWatchProcess.setText(String.valueOf(history.getProcess()));
        }

        @Override
        public int getItemViewType(int position) {
            if(position%2 == ITEM_TYPE.ITEM_TYPE_Left.ordinal()) {
                return ITEM_TYPE.ITEM_TYPE_Left.ordinal();
            } else {
                return ITEM_TYPE.ITEM_TYPE_Right.ordinal();
            }
        }

        @Override
        public int getItemCount() {
            return mHistories.size();
        }


    }
}
