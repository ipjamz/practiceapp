package com.example.peter.findr_practice_app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.peter.findr_practice_app.AdminArrayAdapter;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 12/4/17.
 */

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_admin, R.id.tv_name, admins);

        List<Admin> adminList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Admin admin = new Admin();
            admin.setName("FirstName" + i);
            admin.setEmail("Email" + i);
            adminList.add(admin);
        }

        AdminArrayAdapter adapter = new AdminArrayAdapter(this, R.layout.activity_admin, adminList);
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);

        setContentView(listView);

    }

}
