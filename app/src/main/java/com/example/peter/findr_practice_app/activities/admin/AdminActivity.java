package com.example.peter.findr_practice_app.activities.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.peter.findr_practice_app.activities.adapters.AdminArrayAdapter;
import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.logics.AdminLogic;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.List;

/**
 * Created by peter on 12/4/17.
 */

public class AdminActivity extends AppCompatActivity implements AppCallback<List<Admin>>, View.OnClickListener {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ((Button) findViewById(R.id.btn_new_admin)).setOnClickListener(this);
        listView = (ListView) findViewById(R.id.lv_admins);

        AdminLogic logic = new AdminLogic();
        logic.getAdminList(AdminActivity.this);
    }

    @Override
    public void onSuccess(List<Admin> adminList) {
        AdminArrayAdapter adapter = new AdminArrayAdapter(AdminActivity.this, R.layout.row_admin, adminList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onError(String error) {
        Log.e("AdminList", error);
    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_new_admin)) {
            Intent intent = new Intent(AdminActivity.this, AdminCreateActivity.class);
            startActivity(intent);
        }
    }
}
