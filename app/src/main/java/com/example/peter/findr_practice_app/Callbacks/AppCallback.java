package com.example.peter.findr_practice_app.Callbacks;


import java.util.List;

/**
 * Created by peter on 12/11/17.
 */

public interface AppCallback<T> {
    void onSuccess(T adminList);

    void onError(String error);
}
