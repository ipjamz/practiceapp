package com.example.peter.findr_practice_app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.peter.findr_practice_app.AdminListView;
import com.example.peter.findr_practice_app.R;

/**
 * Created by peter on 12/4/17.
 */

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ListView listView = findViewById(R.id.lv_admins);
        AdminListView adminListView = new AdminListView(this);
        listView.setAdapter(adminListView);
    }
}
