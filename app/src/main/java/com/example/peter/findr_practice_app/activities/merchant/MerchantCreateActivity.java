package com.example.peter.findr_practice_app.activities.merchant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.callbacks.AppCallback;
import com.example.peter.findr_practice_app.logics.MerchantLogic;
import com.example.peter.findr_practice_app.models.merchant.MerchantRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 12/14/17.
 */

public class MerchantCreateActivity extends AppCompatActivity implements View.OnClickListener, AppCallback<String> {

    private Spinner spinner;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_create);


        ((Button) findViewById(R.id.btn_submit)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(this);

        List<String> categories = new ArrayList<>();
        categories.add("FOOD");
        categories.add("RETAIL");
        categories.add("EVENTS");
        categories.add("SERVICES");
        categories.add("TRAVELS");
        categories.add("HEALTH_BEAUTY");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, categories);
        spinner = ((Spinner) findViewById(R.id.sp_category));
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        MerchantRequest merchantRequest = new MerchantRequest();
        merchantRequest.setUserName(((EditText) findViewById(R.id.et_username)).getText().toString());
        merchantRequest.setName(((EditText) findViewById(R.id.et_firstname)).getText().toString());
        merchantRequest.setLastName(((EditText) findViewById(R.id.et_lastname)).getText().toString());
        merchantRequest.setPassword(((EditText) findViewById(R.id.et_password)).getText().toString());
        merchantRequest.setBusinessName(((EditText) findViewById(R.id.et_businessname)).getText().toString());
        merchantRequest.setBusinessAddress(((EditText) findViewById(R.id.et_businessaddress)).getText().toString());
        merchantRequest.setBusinessCategory(spinner.getSelectedItem().toString());

        MerchantLogic merchantLogic = new MerchantLogic();
        merchantLogic.saveMerchant(merchantRequest, this);
    }

    @Override
    public void onSuccess(String object) {
        Log.w("Save", object);
    }

    @Override
    public void onError(String error) {
        Log.w("Error", error);
    }

}
