package com.example.ahmedd.news_app.API.Model.MainModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllMainSources {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sources")
    @Expose
    private List<MainSourceItem> sourcesItems = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MainSourceItem> getSourceItem() {
        return sourcesItems;
    }

    public void setSources(List<MainSourceItem> sources) {
        this.sourcesItems = sources;
    }
}
