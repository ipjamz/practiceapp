package com.example.peter.findr_practice_app.activities.admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.logics.AdminLogic;
import com.example.peter.findr_practice_app.models.Admin;

/**
 * Created by peter on 12/12/17.
 */

public class AdminCreateActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_create);

        ((Button) findViewById(R.id.btn_submit)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_submit)) {
            Admin admin = new Admin();
            admin.setName(((TextView) findViewById(R.id.tv_name)).getText().toString());
            admin.setEmail(((TextView) findViewById(R.id.tv_email)).getText().toString());
            admin.setPassword(((TextView) findViewById(R.id.tv_password)).getText().toString());
            if (confirmPassword(((TextView) findViewById(R.id.tv_password)).getText().toString())) {
                AdminLogic adminLogic = new AdminLogic();
                adminLogic.saveAdmin(admin, new AppCallback<String>() {
                    @Override
                    public void onSuccess(String object) {
                        finish();
                        Log.w("saveAdmin", object);
                    }

                    @Override
                    public void onError(String error) {
                        Log.w("saveAdmin", error);
                    }
                });
            }
        } else if (view == findViewById(R.id.btn_cancel)) {
            finish();
        }
    }

    private boolean confirmPassword(String password) {
        if (password.equals(((TextView) findViewById(R.id.tv_confirm)).getText().toString())) {
            return true;
        }
        return false;
    }

}
