package com.saida_aliyeva.task_dagger2_mvp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saida_aliyeva.task_dagger2_mvp.R;
import com.saida_aliyeva.task_dagger2_mvp.classes.Article;
import com.squareup.picasso.Picasso;

public class RVViewHolder extends RecyclerView.ViewHolder {

    TextView textViewAuthor,textViewTitle;
    ImageView imageViewUrl;
    public RVViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewAuthor=itemView.findViewById(R.id.author);
        textViewTitle=itemView.findViewById(R.id.title);
        imageViewUrl=itemView.findViewById(R.id.image);
    }
   public void onBind(Article article){
   textViewTitle.setText(article.getTitle());
   textViewAuthor.setText(article.getAuthor());
       Picasso.get().load(article.getUrlToImage()).into(imageViewUrl);

   }

}
