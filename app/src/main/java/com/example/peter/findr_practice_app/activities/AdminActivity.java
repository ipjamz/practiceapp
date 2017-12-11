package com.example.peter.findr_practice_app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.peter.findr_practice_app.AdminArrayAdapter;
import com.example.peter.findr_practice_app.AppCallBack;
import com.example.peter.findr_practice_app.PracticeApp;
import com.example.peter.findr_practice_app.PracticeAppPref;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.RestUrlUtil;
import com.example.peter.findr_practice_app.logics.AdminLogic;
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

public class AdminActivity extends AppCompatActivity implements AppCallBack {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AdminLogic logic = new AdminLogic();
        logic.getAdminList(this);
    }

    @Override
    public void onSuccess(Object object) {
        AdminArrayAdapter adapter = new AdminArrayAdapter(AdminActivity.this, R.layout.activity_admin, (List<Admin>) object);
        ListView listView = new ListView(AdminActivity.this);
        listView.setAdapter(adapter);
        setContentView(listView);
    }

    @Override
    public void onError(String error) {
        Log.e("AdminList", error);
    }
}
