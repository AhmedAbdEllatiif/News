package com.example.ahmedd.news_app;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ahmedd.news_app.Adapters.PageAdapter;
import com.example.ahmedd.news_app.Fragments.NewsOFSourceFragment;
import com.example.ahmedd.news_app.Fragments.Sports;
import com.example.ahmedd.news_app.Fragments.Urgent;
import com.example.ahmedd.news_app.Fragments.Weather;

public class News extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView title;
    private Toolbar toolbar;
    public static FrameLayout frameLayout;
    public static String sourceID ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        frameLayout = findViewById(R.id.container_news);
        toolbar = findViewById(R.id.toolbar_news);
        viewPager = findViewById(R.id.News_viewPager);
        tabLayout = findViewById(R.id.tab_layout_news);
        title = findViewById(R.id.my_title_news);
       // title.setText(R.string.urgent);

        tabLayout.setupWithViewPager(viewPager);
        setFragmentWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {



                if (tab.getText().equals(R.string.urgent)){
                    title.setText(R.string.urgent);
                }
                else if (tab.getText().equals(R.string.sports)){
                    title.setText(R.string.sports);
                }
                else if (tab.getText().equals(R.string.weather)){
                    title.setText(R.string.weather);
                }  else if (tab.getText().equals(R.string.news)){
                    title.setText(R.string.news);
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getText().equals(R.string.urgent)){
                    title.setText(R.string.urgent);
                }
                else if (tab.getText().equals(R.string.sports)){
                    title.setText(R.string.sports);
                }
                else if (tab.getText().equals(R.string.weather)){
                    title.setText(R.string.weather);
                }  else if (tab.getText().equals(R.string.news)){
                    title.setText(R.string.news);
                }


            }
        });


        setSupportActionBar(toolbar);
        getSupportActionBar();

        sourceID = getIntent().getStringExtra("id");




    }

    private void setFragmentWithViewPager(ViewPager viewPager){

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.AddFragmentPage(new Urgent(),getString(R.string.urgent));
        adapter.AddFragmentPage(new Sports(),getString(R.string.sports));
        adapter.AddFragmentPage(new Weather(),getString(R.string.weather));
        adapter.AddFragmentPage(new NewsOFSourceFragment(),getString(R.string.news));
        viewPager.setAdapter(adapter);
    }



}
