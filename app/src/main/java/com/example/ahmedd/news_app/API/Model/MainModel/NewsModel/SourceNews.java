package com.example.ahmedd.news_app.API.Model.MainModel.NewsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceNews {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
