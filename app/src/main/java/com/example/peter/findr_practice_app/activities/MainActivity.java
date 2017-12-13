package com.example.peter.findr_practice_app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.activities.admin.AdminActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btn_admin)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_merchant)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_admin)) {
            Intent intent = new Intent(MainActivity.this, AdminActivity.class);
            startActivity(intent);
        } else if (view == findViewById(R.id.btn_merchant)) {
        }
    }
}
