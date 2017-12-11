package com.example.peter.findr_practice_app.Callbacks;

import com.example.peter.findr_practice_app.models.Admin;

import java.util.List;

/**
 * Created by peter on 12/11/17.
 */

public interface AdminCallback {
    void onSuccess(List<Admin> adminList);

    void onError(String error);
}
