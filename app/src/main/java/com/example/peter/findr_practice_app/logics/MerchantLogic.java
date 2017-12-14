package com.example.peter.findr_practice_app.logics;


import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.PracticeAppPref;
import com.example.peter.findr_practice_app.RestUrlUtil;
import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.models.Base;
import com.example.peter.findr_practice_app.models.Status;
import com.example.peter.findr_practice_app.models.merchant.MerchantRequest;
import com.example.peter.findr_practice_app.services.MerchantService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 12/14/17.
 */

public class MerchantLogic {

    public void getMerchantList(final AppCallback<List<Base>> callback) {
        Call<List<Base>> merchantList = RestUrlUtil.getRetrofit().create(MerchantService.class).getMerchantList(PracticeAppPref.getPrefToken(PracticeApp.getContext()));

        merchantList.enqueue(new Callback<List<Base>>() {
            @Override
            public void onResponse(Call<List<Base>> call, Response<List<Base>> response) {
                if (response.body() == null) {
                    callback.onError("error");
                } else {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Base>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void getStatus(String id, boolean isActivated, final AppCallback<String> callback) {
        Call<Status> status = RestUrlUtil.getRetrofit().create(MerchantService.class).getStatus(id, isActivated, PracticeAppPref.getPrefToken(PracticeApp.getContext()));

        status.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess("Success");
                } else {
                    callback.onError("Error");
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void saveMerchant(MerchantRequest request, final AppCallback<String> callback) {
        Call<Status> status = RestUrlUtil.getRetrofit().create(MerchantService.class).saveMerchant(PracticeAppPref.getPrefToken(PracticeApp.getContext()),
                request.getName(), request.getLastName(), request.getUserName(), request.getPassword(), request.getBusinessCategory(), request.getBusinessName(),
                request.getBusinessAddress(), request.getLat(), request.getLng());

        status.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess("Success");
                } else {
                    callback.onError("Error");
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
