package com.college17summer.android.fleeting.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.models.CategoryEntity;
import com.college17summer.android.fleeting.models.HistoryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CategoryAdapter mCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        init();
    }

    private void init() {

        // for test init, you should add your data here.
        List<CategoryEntity> lists = new ArrayList<CategoryEntity>();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
        {
            CategoryEntity a = new CategoryEntity();
            a.setmName("分类 No." + i);
            a.setmDescription("描述" + random.nextInt(100000));
            lists.add(a);
        }

        mRecyclerView = (RecyclerView)findViewById(R.id.categories_video_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mCategoryAdapter = new CategoryAdapter(lists));

    }

    public class CategoryHolder extends RecyclerView.ViewHolder {

        public ImageView ivCategoryCover;
        public TextView tvCategoryName;
        public TextView tvCategoryDescription;
        public CheckBox cbCategoryChosen;


        public CategoryHolder(View itemView) {
            super(itemView);

            ivCategoryCover = (ImageView)itemView.findViewById(R.id.iv_category_cover);
            tvCategoryName = (TextView)itemView.findViewById(R.id.tv_category_name);
            tvCategoryDescription = (TextView)itemView.findViewById(R.id.tv_category_description);
            cbCategoryChosen = (CheckBox)itemView.findViewById(R.id.cb_category_chosen);
        }
    }

    public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {

        private List<CategoryEntity> mCategories;

        public CategoryAdapter(List<CategoryEntity> categories) {
            mCategories = categories;
        }

        @Override
        public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_category, parent, false);
            return new CategoryHolder(view);
        }

        @Override
        public void onBindViewHolder(CategoryHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mCategories.size();
        }
    }
}
