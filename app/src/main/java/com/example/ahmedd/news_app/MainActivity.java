package com.example.ahmedd.news_app;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahmedd.news_app.Fragments.SourceFrgment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new SourceFrgment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit();



    }
}
