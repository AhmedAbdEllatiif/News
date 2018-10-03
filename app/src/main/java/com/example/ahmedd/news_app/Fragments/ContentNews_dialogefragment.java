package com.example.ahmedd.news_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmedd.news_app.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentNews_dialogefragment extends DialogFragment{

    private View view;
    private ImageView imgContent;
    private TextView txtContent;
    private String imgURl;
    private String content;


    public void setImgURl(String imgURl) {
        this.imgURl = imgURl;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public ContentNews_dialogefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
           view =  inflater.inflate(R.layout.fragment_content_news, container, false);
          imgContent = view.findViewById(R.id.img_content);
          txtContent = view.findViewById(R.id.txtContent);

          txtContent.setText(content);
          Picasso.get().load(imgURl).into(imgContent);

      return view;
    }

}
