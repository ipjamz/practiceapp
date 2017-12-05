package com.example.peter.findr_practice_app.logics;

import android.util.Log;

import com.example.peter.findr_practice_app.services.AdminService;
import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.RestUrlUtil;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 12/4/17.
 */

public class AdminLogic {

    public List<Admin> getAdminList() {
        final List<Admin> adminList = new ArrayList<>();
        Log.e("Token", AuthLogic.getPrefToken(PracticeApp.getContext()));
        Call<List<Admin>> call = RestUrlUtil.getRetrofit().create(AdminService.class).getAdminList(AuthLogic.getPrefToken(PracticeApp.getContext()));
        call.enqueue(new Callback<List<Admin>>() {
            @Override
            public void onResponse(Call<List<Admin>> call, Response<List<Admin>> response) {
                if (response.body() != null) {
                    Log.e("Admins", response.body().toString());
                    for (Admin admin : response.body()) {
                        adminList.add(admin);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Admin>> call, Throwable t) {
                Log.e("List<Admin>", "Failed");
            }
        });

        return adminList;
    }
}
