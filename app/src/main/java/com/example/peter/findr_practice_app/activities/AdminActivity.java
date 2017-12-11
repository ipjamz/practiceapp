package com.example.peter.findr_practice_app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.peter.findr_practice_app.AdminArrayAdapter;
import com.example.peter.findr_practice_app.Callbacks.AppCallback;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.logics.AdminLogic;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.List;

/**
 * Created by peter on 12/4/17.
 */

public class AdminActivity extends AppCompatActivity implements AppCallback<List<Admin>> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AdminLogic logic = new AdminLogic();
        logic.getAdminList(this);
    }

    @Override
    public void onSuccess(List<Admin> adminList) {
        AdminArrayAdapter adapter = new AdminArrayAdapter(AdminActivity.this, R.layout.activity_admin, adminList);
        ListView listView = new ListView(AdminActivity.this);
        listView.setAdapter(adapter);
        setContentView(listView);
    }

    @Override
    public void onError(String error) {
        Log.e("AdminList", error);
    }
}
