package com.example.peter.findr_practice_app.logics;

import com.example.peter.findr_practice_app.Callbacks.AuthCallback;
import com.example.peter.findr_practice_app.RestUrlUtil;
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

}
