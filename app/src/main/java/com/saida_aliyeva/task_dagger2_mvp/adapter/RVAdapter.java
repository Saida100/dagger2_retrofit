package com.saida_aliyeva.task_dagger2_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saida_aliyeva.task_dagger2_mvp.R;
import com.saida_aliyeva.task_dagger2_mvp.classes.Article;
import com.saida_aliyeva.task_dagger2_mvp.viewholder.RVViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter  extends RecyclerView.Adapter<RVViewHolder> {
  List<Article>articles=new ArrayList<>();
  Context context;

    public RVAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_article,parent,false);
        return new RVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {
     holder.onBind(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
