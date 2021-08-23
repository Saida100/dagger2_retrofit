package com.saida_aliyeva.task_dagger2_mvp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saida_aliyeva.task_dagger2_mvp.adapter.RVAdapter;
import com.saida_aliyeva.task_dagger2_mvp.classes.Article;
import com.saida_aliyeva.task_dagger2_mvp.classes.BaseApplication;
import com.saida_aliyeva.task_dagger2_mvp.classes.News;
import com.saida_aliyeva.task_dagger2_mvp.interfaces.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RVAdapter rvAdapter;
    List<Article>articles=new ArrayList<>();
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        ((BaseApplication) getApplication()).getApiComponent().inject(this);

       apiInterface=retrofit.create(ApiInterface.class);
        apiInterface.getNews("8dfaa12632764d15a7ea2195a44fbd09").enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                 News news=new News();
                 if(response.code()==200){
                     news=response.body();
                     articles.addAll(news.getArticles());

                     recyclerView.setLayoutManager(linearLayoutManager);
                     rvAdapter=new RVAdapter(articles,getApplicationContext());
                     recyclerView.setAdapter(rvAdapter);
                 }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                t.printStackTrace();
                Log.e("result", t.getMessage());
            }
        });

    }
}