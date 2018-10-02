package com.example.ahmedd.news_app.API;

import com.example.ahmedd.news_app.API.Model.MainModel.AllMainSources;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {


    @GET("sources")
    Call<AllMainSources> allMainSources(@Query("Language") String Language,
                                        @Query("apiKey") String apiKey
                                        );
    //d27e82d8021d4f08aeedc00704903264
}
