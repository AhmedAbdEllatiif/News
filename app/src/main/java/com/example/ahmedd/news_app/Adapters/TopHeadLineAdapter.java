package com.example.ahmedd.news_app.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmedd.news_app.API.APIManger;
import com.example.ahmedd.news_app.API.Model.MainModel.MainSourceItem;
import com.example.ahmedd.news_app.API.Model.MainModel.TopHeadLines.Articles_THL;
import com.example.ahmedd.news_app.API.Model.MainModel.TopHeadLines.Example_THL;
import com.example.ahmedd.news_app.API.Model.MainModel.TopHeadLines.Source_THL;
import com.example.ahmedd.news_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopHeadLineAdapter extends RecyclerView.Adapter<TopHeadLineAdapter.ViewHolder>  {

    private List<Articles_THL> articlItems;
    private onItemClickListener onCardClickListener;
    private final String apiKey = "d27e82d8021d4f08aeedc00704903264";
    private String URL;


    public TopHeadLineAdapter(List<Articles_THL> articlItems) {
        this.articlItems= articlItems;
    }


    public void setOnCardClickListener(onItemClickListener onCardClickListener) {
        this.onCardClickListener = onCardClickListener;
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTopHeadLine;
        private TextView txtDisc_TopHeadLine;
        private ImageView img_topHeadLine;
        private CardView cardView_TopheadLine;


        public ViewHolder(View itemView) {
            super(itemView);

            txtTopHeadLine = itemView.findViewById(R.id.txtTopHeadLine);
            txtDisc_TopHeadLine = itemView.findViewById(R.id.txtDisc_TopHeadLine);
            img_topHeadLine = itemView.findViewById(R.id.img_topHeadLine);
            cardView_TopheadLine = itemView.findViewById(R.id.cardView_TopheadLine);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_topheadline,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Articles_THL item = articlItems.get(position);
        URL  = item.getUrlToImage();
/*

        APIManger.getServices().getHeadLine("eg",apiKey).enqueue(new Callback<Example_THL>() {
            @Override
            public void onResponse(Call<Example_THL> call, Response<Example_THL> response) {
                    URL = response.body().getArticles().get(position).getUrlToImage();
            }

            @Override
            public void onFailure(Call<Example_THL> call, Throwable t) {

            }
        });
*/

        holder.txtTopHeadLine.setText(item.getTitle());
        holder.txtDisc_TopHeadLine.setText(item.getDescription());
        Picasso.get().load(URL).into(holder.img_topHeadLine);

        if(onCardClickListener != null){
            holder.cardView_TopheadLine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCardClickListener.onClick(position,item);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return articlItems.size();
    }

    public interface onItemClickListener{

        void onClick(int position, Articles_THL articlItems);

    }
}
