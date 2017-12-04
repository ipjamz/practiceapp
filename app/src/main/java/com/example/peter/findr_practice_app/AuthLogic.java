package com.example.peter.findr_practice_app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by peter on 12/4/17.
 */

public class AuthLogic {

    private static final String PREF_APP = "com.example.peter.findr_practice_app.PREF_APP";
    private static final String PREF_TOKEN = "com.example.peter.findr_practice_app.PREF_TOKEN";

    private static SharedPreferences getSharedPreference(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE);
        return pref;
    }

    public void setPrefToken(Context context, String token) {
        SharedPreferences pref = getSharedPreference(context);
        pref.edit().putString(PREF_TOKEN, "Bearer " + token).commit();
    }

    public static String getPrefToken(Context context) {
        return getSharedPreference(context).getString(PREF_TOKEN, "");
    }
}
