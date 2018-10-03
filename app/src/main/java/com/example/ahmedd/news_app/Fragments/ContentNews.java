package com.example.ahmedd.news_app.Fragments;


import android.os.Bundle;
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
public class ContentNews extends Fragment {

    private View view;
    private ImageView imgContent;
    private TextView txtContent;

    public static String imgURl;
    public static String content;

    public ContentNews() {
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
