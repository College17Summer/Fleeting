package com.college17summer.android.fleeting.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.models.CollectionEntity;
import com.college17summer.android.fleeting.models.HistoryEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CollectionActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CollectionAdapter mHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        getSupportActionBar().hide();
        init();
    }

    private void init() {

        List<CollectionEntity> collectionLists = new ArrayList<CollectionEntity>();
        Random random = new Random();
        for (int i = 0; i < 100; i++)
        {
            CollectionEntity a = new CollectionEntity();
            collectionLists.add(a);
        }

        mRecyclerView = (RecyclerView)findViewById(R.id.collections_video_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mHistoryAdapter = new CollectionAdapter(collectionLists));

    }

    private class CollectionItemHolder extends RecyclerView.ViewHolder {

        public TextView tvVideoName;

        public CollectionItemHolder(View itemView) {
            super(itemView);

            // bind collection object with layout
            tvVideoName = (TextView)itemView.findViewById(R.id.collection_video_name);

        }
    }


    public class CollectionAdapter extends RecyclerView.Adapter<CollectionItemHolder> {

        private List<CollectionEntity> mCollections;

        public CollectionAdapter(List<CollectionEntity> collections) {
            mCollections = collections;
        }


        @Override
        public CollectionItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_collection, parent, false);
            return new CollectionItemHolder(view);
        }

        @Override
        public void onBindViewHolder(CollectionItemHolder holder, int position) {
            CollectionEntity collection = mCollections.get(position);
            collection.setmVideoId(10001 + position);
        }

        @Override
        public int getItemCount() {
            return mCollections.size();
        }
    }
}
