package com.example.peter.findr_practice_app.logics;

import android.util.Log;

import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.PracticeAppPref;
import com.example.peter.findr_practice_app.services.AdminService;
import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.RestUrlUtil;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 12/4/17.
 */

public class AdminLogic {

    public void getAdminList(final AppCallback<List<Admin>> callBack) {
        Call<List<Admin>> adminsList = RestUrlUtil.getRetrofit().create(AdminService.class).getAdminList(PracticeAppPref.getPrefToken(PracticeApp.getContext()));
        Log.w("Token", PracticeAppPref.getPrefToken(PracticeApp.getContext()));
        adminsList.enqueue(new Callback<List<Admin>>() {
            @Override
            public void onResponse(Call<List<Admin>> call, Response<List<Admin>> response) {
                if (response.body() == null) {
                    callBack.onError("error");
                } else {
                    callBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Admin>> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }

    public void saveAdmin(Admin adminRequest, final AppCallback<String> callback) {
        Call<Admin> admin = RestUrlUtil.getRetrofit().create(AdminService.class).saveAdmin(adminRequest, PracticeAppPref.getPrefToken(PracticeApp.getContext()));
        admin.enqueue(new Callback<Admin>() {
            @Override
            public void onResponse(Call<Admin> call, Response<Admin> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess("Success");
                } else {
                    callback.onError("Error");
                }
            }

            @Override
            public void onFailure(Call<Admin> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }
}
