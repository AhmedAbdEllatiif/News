package com.example.ahmedd.news_app;

import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.ahmedd.news_app.Adapters.PageAdapter;
import com.example.ahmedd.news_app.Fragments.SourceFrgment;
import com.example.ahmedd.news_app.Fragments.TopHeadLinesFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    public static TextView my_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.sourceViewPager);
        tabLayout = findViewById(R.id.tab_layout);
        toolbar = findViewById(R.id.toolbar);
        my_title = findViewById(R.id.my_title);


        tabLayout.setupWithViewPager(viewPager);
        setFragmentWithViewPager(viewPager);

       setSupportActionBar(toolbar);
       getSupportActionBar();





        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals("Sources")){
                    my_title.setText(R.string.source);


                }

                else if (tab.getText().equals("Top Headlines")){
                    my_title.setText(R.string.top_headlines);


                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void setFragmentWithViewPager(ViewPager viewPager){

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.AddFragmentPage(new SourceFrgment(),getString(R.string.source));
        adapter.AddFragmentPage(new TopHeadLinesFragment(),getString(R.string.top_headlines));
        viewPager.setAdapter(adapter);
    }
}
