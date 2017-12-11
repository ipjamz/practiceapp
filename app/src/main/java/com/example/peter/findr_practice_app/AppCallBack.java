package com.example.peter.findr_practice_app;

import com.example.peter.findr_practice_app.models.Authorization;

/**
 * Created by peter on 12/11/17.
 */

public interface AppCallBack {
    void onSuccess(Object object);

    void onError(String error);
}
