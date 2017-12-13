package com.example.peter.findr_practice_app.logics;


import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.PracticeAppPref;
import com.example.peter.findr_practice_app.RestUrlUtil;
import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.models.Merchant;
import com.example.peter.findr_practice_app.services.MerchantService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 12/14/17.
 */

public class MerchantLogic {

    public void getMerchantList(final AppCallback<List<Merchant>> callback) {
        Call<List<Merchant>> merchantList = RestUrlUtil.getRetrofit().create(MerchantService.class).getMerchantList(PracticeAppPref.getPrefToken(PracticeApp.getContext()));

        merchantList.enqueue(new Callback<List<Merchant>>() {
            @Override
            public void onResponse(Call<List<Merchant>> call, Response<List<Merchant>> response) {
                if (response.body() == null) {
                    callback.onError("error");
                } else {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Merchant>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
