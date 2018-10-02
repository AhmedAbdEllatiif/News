package com.example.ahmedd.news_app.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManger {


    private static Retrofit retrofit;

    private static Retrofit getInstance(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static Services getServices(){

        return getInstance().create(Services.class);
    }
}
