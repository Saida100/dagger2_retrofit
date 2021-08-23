package com.saida_aliyeva.task_dagger2_mvp.classes;

import android.app.Application;

import com.saida_aliyeva.task_dagger2_mvp.interfaces.ApiComponent;
import com.saida_aliyeva.task_dagger2_mvp.interfaces.DaggerApiComponent;

public class BaseApplication extends Application {

    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

      apiComponent= DaggerApiComponent.builder().apiInitModule(new ApiInitModule(this))
              .appModule(new AppModule(this)).build();
    }

    public ApiComponent getApiComponent(){
        return apiComponent;
    }

}
