package com.college17summer.android.fleeting.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.models.UserEntity;
import com.college17summer.android.fleeting.views.activities.CategoryActivity;
import com.college17summer.android.fleeting.views.activities.CollectionActivity;
import com.college17summer.android.fleeting.views.activities.CommentActivity;
import com.college17summer.android.fleeting.views.activities.HistoryActivity;
import com.college17summer.android.fleeting.views.activities.LoginActivity;

/**
 * Created by zgh on 17-6-20.
 */

public class SettingFragment extends Fragment {

    private static final String ARG_USER_ID = "mUserId";

    private String mUserId;
    private TextView tvHistory;
    private TextView tvCollection;
    private TextView tvCategory;
    private TextView tvComment;
    private TextView tvLogin;
    private TextView tvUserName;

    public SettingFragment() {
        // Required empty public constructor
    }


    public static SettingFragment newInstance(String mUserId) {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_ID, mUserId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mUserId = getArguments().getString(ARG_USER_ID);
        }
    }

    private void init(View v) {

        tvUserName = (TextView)v.findViewById(R.id.tv_setting_username);

        // bind view collection
        tvCollection = (TextView)v.findViewById(R.id.txt_my_collection);
        tvCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CollectionActivity.class);
                startActivity(intent);
            }
        });

        // bind view category
        tvCategory = (TextView)v.findViewById(R.id.txt_my_category);
        tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryActivity.class);
                startActivity(intent);
            }
        });

        // bind view comment
        tvComment = (TextView)v.findViewById(R.id.txt_my_comment);
        tvComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CommentActivity.class);
                startActivity(intent);
            }
        });

        // bind view history
        tvHistory = (TextView)v.findViewById(R.id.txt_my_history);
        tvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        // bind view login&register
        tvLogin = (TextView)v.findViewById(R.id.txt_log_out);
        if(UserEntity.getUserInstance().getmId() == 0) {
            tvUserName.setText(R.string.not_login);
            tvLogin.setText(R.string.log_in);
        } else {
            tvLogin.setText(R.string.log_out);
            tvUserName.setText(UserEntity.getUserInstance().getmUserName());
        }
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UserEntity.getUserInstance().getmId() == 0) {
                    // login in operation
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent,1);
                } else {
                    // login out operation
                    UserEntity.getUserInstance().setmId(0);
                    UserEntity.getUserInstance().setmUserName("");
                    // Clear username and log out
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserName", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    UserEntity.getUserInstance().setmUserName("");
                    UserEntity.getUserInstance().setmId(0);

                    tvUserName.setText(R.string.not_login);
                    Toast.makeText(getActivity(), R.string.info_login_out, Toast.LENGTH_SHORT).show();
                    tvLogin.setText(R.string.log_in);
                }

            }
        });
    }

    // Update UI
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        init(view);

        updateUI();
        return view;
    }

    private void updateUI() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                UserEntity aUser = UserEntity.getUserInstance();
                aUser.setmId(1);
                aUser.setmUserName(data.getStringExtra("username"));
                aUser.setmPassword(data.getStringExtra("password"));
                Log.d("tag_login","SettingFragment: " + "username: " + aUser.getmUserName() +
                        ", password: " + aUser.getmPassword());
                tvLogin.setText(R.string.log_out);
                tvUserName.setText(aUser.getmUserName());
                break;
            default:
                break;
        }
    }


}
