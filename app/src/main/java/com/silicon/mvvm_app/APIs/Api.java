package com.silicon.mvvm_app.APIs;


import com.silicon.mvvm_app.models.MessagesResponse;
import com.silicon.mvvm_app.models.test;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("admin/messages")
    Call<MessagesResponse> getAdminMessages(
            @Query("token") String api_token
    );


    @GET("getdata.php")
    Call<ArrayList<test>> getdata();
}

