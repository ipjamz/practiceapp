package com.example.peter.findr_practice_app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.peter.findr_practice_app.AdminArrayAdapter;
import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.RestUrlUtil;
import com.example.peter.findr_practice_app.logics.AuthLogic;
import com.example.peter.findr_practice_app.models.Admin;
import com.example.peter.findr_practice_app.services.AdminService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 12/4/17.
 */

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_admin, R.id.tv_name, admins);

//        List<Admin> adminList = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++) {
//            Admin admin = new Admin();
//            admin.setName("FirstName" + i);
//            admin.setEmail("Email" + i);
//            adminList.add(admin);
//        }

        Call<List<Admin>> adminsList = RestUrlUtil.getRetrofit().create(AdminService.class).getAdminList(AuthLogic.getPrefToken(PracticeApp.getContext()));
        Log.e("Token", AuthLogic.getPrefToken(PracticeApp.getContext()));
        adminsList.enqueue(new Callback<List<Admin>>() {
            @Override
            public void onResponse(Call<List<Admin>> call, Response<List<Admin>> response) {
                List<Admin> adminList = response.body();
                if (response.body() == null) {

                } else {
                    AdminArrayAdapter adapter = new AdminArrayAdapter(AdminActivity.this, R.layout.activity_admin, adminList);
                    ListView listView = new ListView(AdminActivity.this);
                    listView.setAdapter(adapter);

                    setContentView(listView);
                }

            }

            @Override
            public void onFailure(Call<List<Admin>> call, Throwable t) {

            }
        });


    }

}
