package com.college17summer.android.fleeting.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.utils.ApiAddress;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class LoginActivity extends AppCompatActivity {

    private String mUserName;
    private String mPassword;

    private AutoCompleteTextView atvUserName;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        init();
    }

    private void init() {
        atvUserName = (AutoCompleteTextView)findViewById(R.id.login_username);
        etPassword = (EditText)findViewById(R.id.login_password);
        btnLogin = (Button)findViewById(R.id.btn_login_register);

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                mUserName = atvUserName.getText().toString();
                mPassword = etPassword.getText().toString();

                Log.d("tag_login","LoginActivity: " + "username: " + mUserName + ", password: " + mPassword);

                //loginServer(ApiAddress.url_login,mUserName,mPassword);


                backForResult();
            }
        });

    }

    private void loginServer(String url,final String userName,String passWord)
    {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formBuilder = new FormBody.Builder();
        formBuilder.add("username", userName);
        formBuilder.add("password", passWord);
        Request request = new Request.Builder().url(url).post(formBuilder.build()).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        //Toast.makeText(null, R.string.info_net_error, Toast.LENGTH_SHORT).show();
                        Log.d("okhttp","fail");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException
            {
                final String res = response.body().string();
                Log.d("okhttp",res);
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        /*
                        if (res.equals("0"))
                        {
                            Toast.makeText(null, R.string.info_net_error, Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            showSuccessSweetDialog(res);
                            sharedPreferences = getSharedPreferences("UserIDAndPassword", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("username", userName);
                            editor.apply();
                        }*/

                    }
                });
            }
        });

    }

    private void backForResult() {

        Intent intent = new Intent();
        intent.putExtra("username", mUserName);
        intent.putExtra("password", mPassword);
        setResult(RESULT_OK, intent);
        finish();
    }




}

