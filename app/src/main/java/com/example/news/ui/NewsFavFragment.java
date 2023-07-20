package com.example.news.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.R;
import com.example.news.data.FakeDataSource;
import com.example.news.ui.news.DiffUtilItemCallback;
import com.example.news.ui.news.NewsListAdapter;

public class NewsFavFragment extends Fragment {
    RecyclerView rvFav;
    NewsListAdapter newsListAdapter;

    public NewsFavFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_fav, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    initFavList(view);

    }
    private void initFavList(@NonNull View view){
        rvFav = view.findViewById(R.id.rv_fav);
        rvFav.setHasFixedSize(true);
        newsListAdapter = new NewsListAdapter(new DiffUtilItemCallback());
        rvFav.setAdapter(newsListAdapter);
        FakeDataSource fakeDataSource = new FakeDataSource();
        newsListAdapter.submitList(fakeDataSource.getFakeListNews());

    }
}