package com.example.news.ui.news;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.news.data.NewsItem;

public class DiffUtilItemCallback extends DiffUtil.ItemCallback<NewsItem> {

    @Override
    public boolean areItemsTheSame(@NonNull NewsItem oldItem, @NonNull NewsItem newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull NewsItem oldItem, @NonNull NewsItem newItem) {
        return oldItem.getId() == newItem.getId();
    }
}
