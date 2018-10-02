package com.example.ahmedd.news_app.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedd.news_app.API.Model.MainModel.MainSourceItem;
import com.example.ahmedd.news_app.R;

import java.util.List;

public class SourcesNameAdapter extends RecyclerView.Adapter<SourcesNameAdapter.ViewHolder> {


    private List<MainSourceItem> sourceItems;
    private onItemClickListener onCardClickListener;

    public SourcesNameAdapter(List<MainSourceItem> radioItems) {
        this.sourceItems= radioItems;
    }


    public void setOnCardClickListener(onItemClickListener onCardClickListener) {
        this.onCardClickListener = onCardClickListener;
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtname;
        CardView cardView_source_name;


        public ViewHolder(View itemView) {
            super(itemView);

            txtname = itemView.findViewById(R.id.name);
            cardView_source_name = itemView.findViewById(R.id.cardView_source_name);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_source_name,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final MainSourceItem item = sourceItems.get(position);

        holder.txtname.setText(item.getName());

        if(onCardClickListener != null){
            holder.cardView_source_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCardClickListener.onClick(position,item);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return sourceItems.size();
    }

    public interface onItemClickListener{

        void onClick(int position, MainSourceItem sourceView);

    }
}
