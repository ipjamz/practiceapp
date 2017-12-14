package com.example.peter.findr_practice_app.activities.merchant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.activities.adapters.MerchantArrayAdapter;
import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.logics.MerchantLogic;
import com.example.peter.findr_practice_app.models.Base;

import java.util.List;

/**
 * Created by peter on 12/14/17.
 */

public class MerchantActivity extends AppCompatActivity implements AppCallback<List<Base>>, View.OnClickListener {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_merchant);
        listView = (ListView) findViewById(R.id.lv_merchants);
        ((Button) findViewById(R.id.btn_new_merchant)).setOnClickListener(this);

        MerchantLogic merchantLogic = new MerchantLogic();
        merchantLogic.getMerchantList(this);

    }

    @Override
    public void onSuccess(List<Base> object) {
        MerchantArrayAdapter adapter = new MerchantArrayAdapter(this, R.layout.row_merchant, object);
        listView.setAdapter(adapter);
    }

    @Override
    public void onError(String error) {
        Log.w("Error", error);
    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_new_merchant)) {
            Intent intent = new Intent(this, MerchantCreateActivity.class);
            startActivity(intent);
        }
    }
}
