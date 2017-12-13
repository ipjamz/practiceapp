package com.example.peter.findr_practice_app.services;

import com.example.peter.findr_practice_app.models.Merchant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by peter on 12/14/17.
 */

public interface MerchantService {

    @GET("/api/merchant/list")
    Call<List<Merchant>> getMerchantList(@Header("Authorization") String token);
}
