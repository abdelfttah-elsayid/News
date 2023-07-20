package com.example.news.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;
import com.example.news.data.FakeDataSource;
import com.example.news.data.NewsItem;
import com.example.news.ui.news.DiffUtilItemCallback;
import com.example.news.ui.news.NewsListAdapter;

public class SearchFragment extends Fragment {
    RecyclerView rvSearch;
    NewsListAdapter adapter;

    public SearchFragment() {
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
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSearch= view.findViewById(R.id.search_rv);
        rvSearch.setLayoutManager(new GridLayoutManager(getContext() , 2));
        rvSearch.setHasFixedSize(true);
        adapter = new NewsListAdapter(new DiffUtilItemCallback());
        rvSearch.setAdapter(adapter);
        FakeDataSource fakeDataSource = new FakeDataSource();
        adapter.submitList(fakeDataSource.getFakeListNews());



    }
}