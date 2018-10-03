package com.example.ahmedd.news_app.BaseActivities;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.afollestad.materialdialogs.MaterialDialog;

public class BaseFragment extends Fragment {

    protected BaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BaseActivity) context;


    }

    public MaterialDialog showMessage(String title, String Message){
        return  activity.showMessage(title,Message);
    }

    public MaterialDialog showProgressBar(){
        return activity.showProgressBar("Please Wait", "Loading");
    }

    public void hideProgressBar(){

        activity.hideProgressBar();
    }

}
