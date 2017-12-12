package com.example.peter.findr_practice_app;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by peter on 12/1/17.
 */

public class RestUrlUtil {

    public static Retrofit getRetrofit() {
        Log.w("LOCAL_URL", BuildConfig.LOCAL_URL);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.LOCAL_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }


}

