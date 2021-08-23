package com.saida_aliyeva.task_dagger2_mvp.classes;

import com.saida_aliyeva.task_dagger2_mvp.interfaces.ApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiInitModule {

    private Retrofit retrofit;
    private ApiInterface apiInterface;
    private BaseApplication baseApplication;

    public ApiInitModule(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }


    @Provides
    @Singleton
    public Retrofit initRetrofit(){
        retrofit=new Retrofit.Builder()
                .baseUrl(Constants.API_LINk)
                .client(httpLogging())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    public OkHttpClient httpLogging(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient();
        okHttpClient=okHttpClient.newBuilder().
                addInterceptor(httpLoggingInterceptor)
                .build();
        return okHttpClient;
    }

    @Provides
    public ApiInterface getClient(){
        if(apiInterface==null){
            apiInterface=retrofit.create(ApiInterface.class);
        }
        return  apiInterface;
    }
}
