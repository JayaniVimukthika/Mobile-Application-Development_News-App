package com.jayani.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapterRelated extends RecyclerView.Adapter<NewsAdapterRelated.ViewHolder>{
    private List<NewsItem> newsList;
    private NewsAdapterRelated.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(NewsItem item);
    }

    public NewsAdapterRelated(List<NewsItem> newsList, NewsAdapterRelated.OnItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @Override
    public NewsAdapterRelated.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_related, parent, false);
        return new NewsAdapterRelated.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapterRelated.ViewHolder holder, int position) {
        NewsItem item = newsList.get(position);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView newsImage;
        private TextView newsDis;
        private TextView news_Title;

        public ViewHolder(View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.news_image3);
            newsDis = itemView.findViewById(R.id.news_discription3);
            news_Title = itemView.findViewById(R.id.news_Title3);
        }

        public void bind(final NewsItem item, final NewsAdapterRelated.OnItemClickListener listener) {
            newsImage.setImageResource(item.getImageResource());
            newsDis.setText(item.getDescription());
            news_Title.setText(item.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}

