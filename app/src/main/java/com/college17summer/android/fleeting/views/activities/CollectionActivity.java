package com.college17summer.android.fleeting.views.activities;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.models.CollectionVideoLabEntity;
import com.college17summer.android.fleeting.models.VideoEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.vov.vitamio.provider.MediaStore;

public class CollectionActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CollectionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        // getSupportActionBar().hide();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }


    private void init() {

        Log.e("", "Collection list init: OK");
        List<VideoEntity> videos = CollectionVideoLabEntity.get(getApplicationContext()).getVideos();

        mRecyclerView = (RecyclerView)findViewById(R.id.collections_video_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CollectionAdapter(videos);
        mRecyclerView.setAdapter(adapter);
    }



    private class CollectionItemHolder extends RecyclerView.ViewHolder {

        public TextView tvVideoTitle;
        public TextView tvVideoType;
        public SimpleDraweeView dvVideoCover;
        public ImageButton btnVideoPlay;

        public CollectionItemHolder(View itemView) {
            super(itemView);
            // bind collection object with layout
            dvVideoCover = (SimpleDraweeView) itemView.findViewById(R.id.collection_cover);
            tvVideoTitle = (TextView)itemView.findViewById(R.id.collection_video_title);
            tvVideoType = (TextView)itemView.findViewById(R.id.collection_video_type);
            btnVideoPlay = (ImageButton) itemView.findViewById(R.id.button_video_play);
        }
    }


    public class CollectionAdapter extends RecyclerView.Adapter<CollectionItemHolder> {

        private List<VideoEntity> mCollections;

        public CollectionAdapter(List<VideoEntity> collections) {
            mCollections = collections;
        }


        @Override
        public CollectionItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            View view = layoutInflater.inflate(R.layout.item_collection, parent, false);

            Log.e("Collection holder", "onCreateViewHolder: OK");
            return new CollectionItemHolder(view);
        }

        @Override
        public void onBindViewHolder(CollectionItemHolder holder, int position) {
            final VideoEntity videoEntity = this.mCollections.get(position);
            holder.dvVideoCover.setImageURI(videoEntity.getmVideoCover());
            holder.tvVideoTitle.setText(videoEntity.getmVideoTitle());
            holder.tvVideoType.setText(videoEntity.getmVideoType());
            holder.btnVideoPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), VideoPlayActivity.class);
                    intent.putExtra("videoUrl", videoEntity.getmVideoUrl());
                    intent.putExtra("videoTitle", videoEntity.getmVideoTitle());
                    intent.putExtra("videoType", videoEntity.getmVideoType());
                    intent.putExtra("videoId", videoEntity.getmVideoId());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mCollections.size();
        }
    }
}
