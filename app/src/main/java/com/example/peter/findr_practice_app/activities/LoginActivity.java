package com.example.peter.findr_practice_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.PracticeAppPref;
import com.example.peter.findr_practice_app.logics.AuthLogic;
import com.example.peter.findr_practice_app.models.Authorization;
import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.models.LoginRequest;

/**
 * Created by peter on 11/29/17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((Button) findViewById(R.id.btn_login)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_login)) {
            LoginRequest loginRequest = new LoginRequest();
//                loginRequest.setUsername(((TextView) findViewById(R.id.et_username)).getText().toString());
//                loginRequest.setPassword(((TextView) findViewById(R.id.et_password)).getText().toString());
            loginRequest.setUsername("admin@satellite.com.ph");
            loginRequest.setPassword("admin");

            AuthLogic authLogic = new AuthLogic();
            authLogic.authorize(loginRequest, new AppCallback<Authorization>() {
                @Override
                public void onSuccess(Authorization object) {
                    Log.w("Token", object.getToken());
                    PracticeAppPref.setPrefToken(PracticeApp.getContext(), object.getToken());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onError(String error) {
                    Log.e("Auth", error);

                }
            });
        }
    }
}