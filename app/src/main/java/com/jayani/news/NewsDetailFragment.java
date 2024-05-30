package com.jayani.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailFragment extends Fragment {

    private static final String ARG_NEWS_ITEM = "news_item";
    private NewsItem newsItem;

    public static NewsDetailFragment newInstance(NewsItem newsItem) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_NEWS_ITEM, newsItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            newsItem = (NewsItem) getArguments().getSerializable(ARG_NEWS_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        ImageView newsImage = view.findViewById(R.id.news_image);
        TextView newsDescription = view.findViewById(R.id.news_description);
        TextView newsTitle = view.findViewById(R.id.news_Title);
        RecyclerView recyclerViewRelatedNews = view.findViewById(R.id.recycler_view_related_news);

        newsImage.setImageResource(newsItem.getImageResource());
        newsDescription.setText(newsItem.getDescription());
        newsTitle.setText(newsItem.getTitle());

        List<NewsItem> relatedNews = getRelatedNews(newsItem);
        recyclerViewRelatedNews.setLayoutManager(new LinearLayoutManager(getContext()));
        NewsAdapterRelated relatedNewsAdapter = new NewsAdapterRelated(relatedNews, new NewsAdapterRelated.OnItemClickListener() {
            @Override
            public void onItemClick(NewsItem item) {
            }
        });
        recyclerViewRelatedNews.setAdapter(relatedNewsAdapter);

        return view;
    }

    private List<NewsItem> getRelatedNews(NewsItem newsItem) {
        List<NewsItem> relatedNews = new ArrayList<>();
        relatedNews.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        relatedNews.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        relatedNews.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        // Add more related news here
        return relatedNews;
    }
}
