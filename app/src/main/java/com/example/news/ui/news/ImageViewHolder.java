package com.example.news.ui.news;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.news.data.NewsItem;
import com.example.news.databinding.ItemNewsImageBinding;
import com.example.news.databinding.ItemNewsTextBinding;

public class ImageViewHolder extends BaseViewHolder {
    ItemNewsImageBinding itemNewsImageBinding ;


    public ImageViewHolder(@NonNull ItemNewsImageBinding itemNewsImageBinding) {
        super(itemNewsImageBinding.getRoot());
        this.itemNewsImageBinding= itemNewsImageBinding;

    }

    @Override
    public void bindData(NewsItem item) {
        itemNewsImageBinding.setNewsItemImage(item);

    }

    @Override
    public ItemNewsTextBinding getItemNewsTextBinding() {
        return null;
    }

    @Override
    public ItemNewsImageBinding getItemNewsImageBinding() {
        return null;
    }
}
