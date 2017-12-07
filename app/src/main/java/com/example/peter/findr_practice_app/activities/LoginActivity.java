package com.example.peter.findr_practice_app.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.peter.findr_practice_app.logics.AuthLogic;
import com.example.peter.findr_practice_app.services.AuthService;
import com.example.peter.findr_practice_app.models.Authorization;
import com.example.peter.findr_practice_app.models.LoginRequest;
import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.RestUrlUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by peter on 11/29/17.
 */

public class LoginActivity extends AppCompatActivity implements AuthCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ((Button) findViewById(R.id.btn_login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                LoginRequest loginRequest = new LoginRequest();
//                loginRequest.setUsername(((TextView) findViewById(R.id.et_username)).getText().toString());
//                loginRequest.setPassword(((TextView) findViewById(R.id.et_password)).getText().toString());
//
//                final AuthLogic authLogic = new AuthLogic();
//                authLogic.authorize(loginRequest, LoginActivity.this);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }

        });
    }

    @Override
    public void onSuccess(Authorization authorization) {
        AuthLogic.setPrefToken(LoginActivity.this, authorization.getToken());
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onError(String error) {
        Log.e("Auth", error);
    }
}