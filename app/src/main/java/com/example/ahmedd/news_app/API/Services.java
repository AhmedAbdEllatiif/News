package com.example.ahmedd.news_app.API;

import com.example.ahmedd.news_app.API.Model.MainModel.AllMainSources;
import com.example.ahmedd.news_app.API.Model.MainModel.TopHeadLines.Example_THL;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {


    @GET("sources")
    Call<AllMainSources> allMainSources(@Query("language") String language,
                                        @Query("apiKey") String apiKey
                                        );
    //d27e82d8021d4f08aeedc00704903264

    @GET("top-headlines")
    Call<Example_THL> getHeadLine(@Query("country") String country,
                                  @Query("apiKey") String apiKey
                                  );

}
