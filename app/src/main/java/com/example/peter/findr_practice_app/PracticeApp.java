package com.example.peter.findr_practice_app;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;

/**
 * Created by peter on 12/4/17.
 */

public class PracticeApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        PracticeApp.context = getApplicationContext();
        Realm.init(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Context getContext() {
        return PracticeApp.context;
    }
}
