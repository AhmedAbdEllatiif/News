package com.example.ahmedd.news_app.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ahmedd.news_app.API.Model.MainModel.NewsModel.ArticleNews;
import com.example.ahmedd.news_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AllNewsAdapter extends RecyclerView.Adapter<AllNewsAdapter.ViewHolder> {

    private List<ArticleNews> articletems;
    private onItemClickListener onCardClickListener;
    private String URL;


    public AllNewsAdapter(List<ArticleNews> articletems) {
        this.articletems = articletems;
    }


    public void setOnCardClickListener(onItemClickListener onCardClickListener) {
        this.onCardClickListener = onCardClickListener;
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtNewsTitle;
        private TextView txtDisc_news;
        private ImageView img_News;
        private CardView cardView_News;


        public ViewHolder(View itemView) {
            super(itemView);

            txtNewsTitle = itemView.findViewById(R.id.txtNewsTitle);
            txtDisc_news = itemView.findViewById(R.id.txtDisc_news);
            img_News = itemView.findViewById(R.id.img_News);
            cardView_News = itemView.findViewById(R.id.cardView_News);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_allnews,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final ArticleNews item = articletems.get(position);
        URL  = item.getUrlToImage();

        holder.txtNewsTitle.setText(item.getTitle());
        holder.txtDisc_news.setText(item.getDescription());
        Picasso.get().load(URL).into(holder.img_News);

        if(onCardClickListener != null){
            holder.cardView_News.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCardClickListener.onClick(position,item);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return articletems.size();
    }

    public interface onItemClickListener{

        void onClick(int position, ArticleNews articlItems);

    }


}
