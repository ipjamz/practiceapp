package com.example.peter.findr_practice_app.services;

import com.example.peter.findr_practice_app.models.Admin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by peter on 12/4/17.
 */

public interface AdminService {

    @POST("/api/admin/list")
    Call<List<Admin>> getAdminList(@Header("Authorization") String token);
}
