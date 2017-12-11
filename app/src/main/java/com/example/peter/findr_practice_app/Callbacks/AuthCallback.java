package com.example.peter.findr_practice_app.Callbacks;

import com.example.peter.findr_practice_app.models.Authorization;

/**
 * Created by peter on 12/11/17.
 */

public interface AuthCallback {
    void onSuccess(Authorization authorization);

    void onError(String error);
}
