package com.example.peter.findr_practice_app.activities.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.peter.findr_practice_app.RealmDao;
import com.example.peter.findr_practice_app.activities.adapters.AdminArrayAdapter;
import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.logics.AdminLogic;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.List;

import io.realm.Realm;

/**
 * Created by peter on 12/4/17.
 */

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        realm = Realm.getDefaultInstance();

        ((Button) findViewById(R.id.btn_new_admin)).setOnClickListener(this);
        listView = (ListView) findViewById(R.id.lv_admins);

        getAdminList();
        displayAdminList();
    }


    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_new_admin)) {
            Intent intent = new Intent(AdminActivity.this, AdminCreateActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    private void getAdminList() {
        final AdminLogic logic = new AdminLogic();
        logic.getAdminList(new AppCallback<List<Admin>>() {
            @Override
            public void onSuccess(List<Admin> object) {
                Log.w("getAdminList", "success");
                logic.saveAdminToRealm(object, realm, new AppCallback<String>() {
                    @Override
                    public void onSuccess(String object) {
                        Log.w("saveAdminToRealm", object);
                    }

                    @Override
                    public void onError(String error) {
                        Log.w("saveAdminToRealm", error);
                    }
                });
            }

            @Override
            public void onError(String error) {
                Log.w("getAdminList", error);
            }
        });
    }

    private void displayAdminList() {
        AdminLogic logic = new AdminLogic();
        logic.findAdminList(realm, new AppCallback<List<Admin>>() {
            @Override
            public void onSuccess(List<Admin> object) {
                AdminArrayAdapter adapter = new AdminArrayAdapter(AdminActivity.this, R.layout.row_admin, object);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(String error) {
                Log.w("findAdminlist", error);
            }
        });
    }
}
