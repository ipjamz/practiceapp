package com.example.peter.findr_practice_app.logics;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.RestUrlUtil;
import com.example.peter.findr_practice_app.activities.AuthCallback;
import com.example.peter.findr_practice_app.activities.LoginActivity;
import com.example.peter.findr_practice_app.activities.MainActivity;
import com.example.peter.findr_practice_app.models.Authorization;
import com.example.peter.findr_practice_app.models.LoginRequest;
import com.example.peter.findr_practice_app.services.AuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 12/4/17.
 */

public class AuthLogic {

    private static final String PREF_APP = "com.example.peter.findr_practice_app.PREF_APP";
    private static final String PREF_TOKEN = "com.example.peter.findr_practice_app.PREF_TOKEN";

    public void authorize(LoginRequest loginRequest, final AuthCallback callback) {

        Call<Authorization> call = RestUrlUtil.getRetrofit().create(AuthService.class).login(loginRequest);
        call.enqueue(new Callback<Authorization>() {
            @Override
            public void onResponse(Call<Authorization> call, Response<Authorization> response) {
                if (response.body() == null) {
                    callback.onError("error");
                } else {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Authorization> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    private static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE);
    }

    public static void setPrefToken(Context context, String token) {
        SharedPreferences pref = getSharedPreference(context);
        pref.edit().putString(PREF_TOKEN, "Bearer " + token).commit();
    }

    public static String getPrefToken(Context context) {
        return getSharedPreference(context).getString(PREF_TOKEN, "");
    }
}
