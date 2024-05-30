package com.jayani.news;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        List<NewsItem> topStories = getTopStories();
        List<NewsItem> news = getNews();

        RecyclerView recyclerViewTopStories = findViewById(R.id.recycler_view_top_stories);
        recyclerViewTopStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        NewsAdapter topStoriesAdapter = new NewsAdapter(topStories, new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(NewsItem item) {
                showNewsDetail(item);
            }
        });
        recyclerViewTopStories.setAdapter(topStoriesAdapter);

        RecyclerView recyclerViewNews = findViewById(R.id.recycler_view_news);
        recyclerViewNews.setLayoutManager(new GridLayoutManager(this, 2));
        NewsAdapterBelow newsAdapter = new NewsAdapterBelow(news, new NewsAdapterBelow.OnItemClickListener() {
            @Override
            public void onItemClick(NewsItem item) {
                showNewsDetail(item);
            }
        });
        recyclerViewNews.setAdapter(newsAdapter);
    }

    private void showNewsDetail(NewsItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        NewsDetailFragment fragment = NewsDetailFragment.newInstance(item);
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private List<NewsItem> getTopStories() {
        List<NewsItem> topStories = new ArrayList<>();
        topStories.add(new NewsItem("Top Story 1", "Description 1", R.drawable.maxresdefault));
        topStories.add(new NewsItem("Top Story 2", "Description 2", R.drawable.maxresdefault));
        topStories.add(new NewsItem("Top Story 2", "Description 2", R.drawable.maxresdefault));
        topStories.add(new NewsItem("Top Story 2", "Description 2", R.drawable.maxresdefault));
        return topStories;
    }

    private List<NewsItem> getNews() {
        List<NewsItem> news = new ArrayList<>();
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        news.add(new NewsItem("News 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.maxresdefault));
        return news;
    }
}
