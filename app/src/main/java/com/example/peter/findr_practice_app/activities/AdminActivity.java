package com.example.peter.findr_practice_app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.peter.findr_practice_app.AdminArrayAdapter;
import com.example.peter.findr_practice_app.R;

/**
 * Created by peter on 12/4/17.
 */

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] admins = {"Admin1", "Admin2", "Admin3"};
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_admin, R.id.tv_name, admins);
        AdminArrayAdapter adapter = new AdminArrayAdapter(this, R.layout.activity_admin, admins);
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);

        setContentView(listView);

    }

}
