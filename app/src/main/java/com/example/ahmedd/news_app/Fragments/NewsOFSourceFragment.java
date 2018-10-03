package com.example.ahmedd.news_app.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ahmedd.news_app.API.APIManger;
import com.example.ahmedd.news_app.API.Model.MainModel.NewsModel.ArticleNews;
import com.example.ahmedd.news_app.API.Model.MainModel.NewsModel.ExampleNews;
import com.example.ahmedd.news_app.Adapters.AllNewsAdapter;
import com.example.ahmedd.news_app.BaseActivities.BaseFragment;
import com.example.ahmedd.news_app.News;
import com.example.ahmedd.news_app.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsOFSourceFragment extends BaseFragment {

    private List<ArticleNews> articleItems;
    private RecyclerView recyclerView;
    private AllNewsAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private View view;

    //API
    private final String apiKey = "d27e82d8021d4f08aeedc00704903264";
    private final String serachAll = "all";
    private String content;
    private String URL;
    String sourceID = News.sourceID;



    public NewsOFSourceFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (News.sourceID == null){
            Log.e("ID","null");
        }
        else if(News.sourceID != null) {
            Log.e("ID", News.sourceID);
            sourceID = News.sourceID;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_news_ofsource, container, false);
        recyclerView = view.findViewById(R.id.allNews_recyclerView);

        getApi(serachAll,sourceID,apiKey);
        return view;
    }

    private void setAdapter(){
        adapter = new AllNewsAdapter(articleItems);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void getApi(String searchType,String id, String apiKey){
        APIManger.getServices().getAllNews(searchType,id,apiKey)
                .enqueue(new Callback<ExampleNews>() {
                    @Override
                    public void onResponse(Call<ExampleNews> call, final Response<ExampleNews> response) {

                        switch (response.code()){
                            case (200):
                                Log.e("Code 200", "Success"); break;
                            case (400):
                                Log.e("Error 400", "Bad Request"); break;

                            case (401):
                                Log.e("Error 401", "Unauthorized"); break;

                            case (403):
                                Log.e("Error 403", "Forbidden"); break;

                            case (404):
                                Log.e("Error 404", "not Found"); break;

                            case (409):
                                Log.e("Error 409", "Confilct"); break;

                            case (500):
                                Log.e("Error 500", "500 Internal Server Error"); break;
                        }

                        articleItems =  response.body().getArticles();
                        setAdapter();

                        adapter.setOnCardClickListener(new AllNewsAdapter.onItemClickListener() {
                            @Override
                            public void onClick(int position, ArticleNews articlItems) {

                                URL = response.body().getArticles().get(position).getUrlToImage();
                                content = response.body().getArticles().get(position).getContent();

                                ContentNews_dialogefragment contentNewsDialogefragment = new ContentNews_dialogefragment();
                                contentNewsDialogefragment.setContent(content);
                                contentNewsDialogefragment.setImgURl(URL);

                                contentNewsDialogefragment.show(getChildFragmentManager(),"Dialoge");
                            }
                        });

                    }

                    @Override
                    public void onFailure(Call<ExampleNews> call, Throwable t) {
                        showMessage("Error","Connction Failed");
                    }
                });

    }

}
