package com.example.ahmedd.news_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ahmedd.news_app.API.APIManger;
import com.example.ahmedd.news_app.API.Model.MainModel.TopHeadLines.Articles_THL;
import com.example.ahmedd.news_app.API.Model.MainModel.TopHeadLines.Example_THL;
import com.example.ahmedd.news_app.Adapters.TopHeadLineAdapter;
import com.example.ahmedd.news_app.MainActivity;
import com.example.ahmedd.news_app.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopHeadLinesFragment extends Fragment {


    public TopHeadLinesFragment() {
        // Required empty public constructor
    }

    private List<Articles_THL> articleItems;
    private RecyclerView recyclerView;
    private TopHeadLineAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private View view;
    private final String apiKey = "d27e82d8021d4f08aeedc00704903264";
    private final String eg_country = "eg";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_top_head_lines, container, false);
        recyclerView = view.findViewById(R.id.topHeadLine_recyclerView);

        getApi(eg_country,apiKey);

        return view;
    }

    private void setAdapter(){
        adapter = new TopHeadLineAdapter(articleItems);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void getApi(String country, String apiKey){
        APIManger.getServices().getHeadLine(country,apiKey)
                .enqueue(new Callback<Example_THL>() {
                    @Override
                    public void onResponse(Call<Example_THL> call, Response<Example_THL> response) {

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
                    }

                    @Override
                    public void onFailure(Call<Example_THL> call, Throwable t) {
                        Toast.makeText(getActivity().getApplicationContext(), "Connection Error", Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
