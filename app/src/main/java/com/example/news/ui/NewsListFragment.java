package com.example.news.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.R;
import com.example.news.data.FakeDataSource;
import com.example.news.ui.news.DiffUtilItemCallback;
import com.example.news.ui.news.NewsListAdapter;


public class NewsListFragment extends Fragment {
    RecyclerView recyclerView;
    NewsListAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;


    public NewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_list_news);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter = new NewsListAdapter(new DiffUtilItemCallback());
        recyclerView.setAdapter(adapter);

        FakeDataSource fakeDataSource = new FakeDataSource();
        adapter.submitList(fakeDataSource.getFakeListNews());
         swipeRefreshLayout = view.findViewById(R.id.news_list_swipe);
         swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
             @Override
             public void onRefresh() {
                 Handler handler = new Handler();
                 handler.postDelayed(new Runnable() {
                     @Override
                     public void run() {

            adapter.submitList(fakeDataSource.getFakeListNews());
            swipeRefreshLayout.setRefreshing(false);
            adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                @Override
                public void onItemRangeInserted(int positionStart, int itemCount) {
                    super.onItemRangeInserted(positionStart, itemCount);
                    recyclerView.smoothScrollToPosition(positionStart);


                }
            });
                     }
                 }, 1000);
             }
         });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false);
    }
}