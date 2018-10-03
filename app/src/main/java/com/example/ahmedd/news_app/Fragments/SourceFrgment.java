package com.example.ahmedd.news_app.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ahmedd.news_app.API.APIManger;
import com.example.ahmedd.news_app.API.Model.MainModel.AllMainSources;
import com.example.ahmedd.news_app.API.Model.MainModel.MainSourceItem;
import com.example.ahmedd.news_app.Adapters.SourcesNameAdapter;
import com.example.ahmedd.news_app.BaseActivities.BaseFragment;
import com.example.ahmedd.news_app.MainActivity;
import com.example.ahmedd.news_app.News;
import com.example.ahmedd.news_app.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SourceFrgment extends BaseFragment {

    private View view;
    private SourcesNameAdapter adapter;
    private List<MainSourceItem> sourceItems;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private String ID = "";

    //api parameters
    private final String apiKey = "d27e82d8021d4f08aeedc00704903264";
    private final String en_language = "en";
    private final String country = "eg";
    private final String ar_language = "ar";

    public SourceFrgment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_source, container, false);
        recyclerView = view.findViewById(R.id.sourceName_recyclerView);
        getApi(en_language,apiKey);
        return view;

    }

    private void setAdapter(){
        adapter = new SourcesNameAdapter(sourceItems);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }

    private void getApi(String language, String apiKey){

        APIManger.getServices().allMainSources(language,apiKey)
                .enqueue(new Callback<AllMainSources>() {
                    @Override
                    public void onResponse(Call<AllMainSources> call, final Response<AllMainSources> response) {

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

                       sourceItems = response.body().getSourceItem();
                        setAdapter();
                        adapter.setOnCardClickListener(new SourcesNameAdapter.onItemClickListener() {
                            @Override
                            public void onClick(int position, MainSourceItem sourceView) {
                                Log.e("Recycler", "Cliclked");
                                Intent intent = new Intent(getActivity(), News.class);
                                ID = response.body().getSourceItem().get(position).getId();
                                intent.putExtra("id", ID);
                                startActivity(intent);

                           /* Fragment fragment = new NewsOFSourceFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.fragment_container,fragment); // give your fragment container id in first parameter
                            transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                            transaction.commit();*/
                            }
                        });



                    }

                    @Override
                    public void onFailure(Call<AllMainSources> call, Throwable t) {
                        showMessage("Error","Connction Failed");
                    }
                });

    }

}
