package com.example.peter.findr_practice_app;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by peter on 12/1/17.
 */

public interface AuthService {

    @POST("/api/auth")
    Call<Authorization> login(@Body LoginRequest loginRequest);
}
