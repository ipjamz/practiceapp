package com.example.peter.findr_practice_app.services;

import com.example.peter.findr_practice_app.models.Merchant;
import com.example.peter.findr_practice_app.models.Status;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by peter on 12/14/17.
 */

public interface MerchantService {

    @GET("/api/merchant/list")
    Call<List<Merchant>> getMerchantList(@Header("Authorization") String token);

    @POST("/api/merchant/togglestatus")
    Call<Status> getStatus(@Query("id") String id, @Query("status") boolean isActivated, @Header("Authorization") String token);
}
