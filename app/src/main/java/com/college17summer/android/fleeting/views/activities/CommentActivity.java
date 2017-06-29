package com.college17summer.android.fleeting.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.models.CommentEntity;
import com.college17summer.android.fleeting.models.HistoryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommentActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CommentAdapter mCommentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        getSupportActionBar().hide();
        init();
    }

    private void init() {

        // for test init, you should add your data here.
        List<CommentEntity> lists = new ArrayList<CommentEntity>();
        Random random = new Random();
        for (int i = 0; i < 100; i++)
        {
            CommentEntity a = new CommentEntity();
            a.setmContent("Comment Content" + i);
            lists.add(a);
        }

        mRecyclerView = (RecyclerView)findViewById(R.id.comments_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mCommentAdapter = new CommentAdapter(lists));

    }

    public class CommentHolder extends RecyclerView.ViewHolder {

        public CommentHolder(View itemView) {
            super(itemView);
        }
    }

    public class CommentAdapter extends RecyclerView.Adapter<CommentHolder> {

        private List<CommentEntity> mComments;

        public CommentAdapter(List<CommentEntity> comments) {
            mComments = comments;
        }

        @Override
        public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_comment, parent, false);
            return new CommentHolder(view);
        }

        @Override
        public void onBindViewHolder(CommentHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mComments.size();
        }
    }
}
