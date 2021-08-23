package com.saida_aliyeva.task_dagger2_mvp.interfaces;

import com.saida_aliyeva.task_dagger2_mvp.classes.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {



    //    //https://newsapi.org/v2/everything?q=apple&from=2021-08-19&to=2021-08-19&sortBy=popularity&apiKey=8dfaa12632764d15a7ea2195a44fbd09
    @GET("v2/everything?q=apple&from=2021-08-19&to=2021-08-19&sortBy=popularity")
    Call<News> getNews(@Query("apiKey") String apiKey);
}
