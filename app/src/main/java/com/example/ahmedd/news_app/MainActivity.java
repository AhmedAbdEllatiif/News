package com.example.ahmedd.news_app;

import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.ahmedd.news_app.Adapters.PageAdapter;
import com.example.ahmedd.news_app.Fragments.SourceFrgment;
import com.example.ahmedd.news_app.Fragments.TopHeadLines;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.sourceViewPager);
        tabLayout = findViewById(R.id.tab_layout);
        toolbar = findViewById(R.id.toolbar);

        tabLayout.setupWithViewPager(viewPager);
        setFragmentWithViewPager(viewPager);

       setSupportActionBar(toolbar);
       getSupportActionBar();





    }


    private void setFragmentWithViewPager(ViewPager viewPager){

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.AddFragmentPage(new SourceFrgment(),getString(R.string.source));
        adapter.AddFragmentPage(new TopHeadLines(),getString(R.string.top_headlines));
        viewPager.setAdapter(adapter);
    }
}
