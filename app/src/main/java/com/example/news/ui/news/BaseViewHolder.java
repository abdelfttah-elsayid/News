package com.example.news.ui.news;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.data.NewsItem;
import com.example.news.databinding.ItemNewsImageBinding;
import com.example.news.databinding.ItemNewsTextBinding;
import com.example.news.databinding.ItemNewsTextBindingImpl;

abstract class BaseViewHolder  extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public abstract void bindData(NewsItem item);

        public abstract ItemNewsTextBinding getItemNewsTextBinding();
        public abstract ItemNewsImageBinding getItemNewsImageBinding();



}
