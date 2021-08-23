package com.saida_aliyeva.task_dagger2_mvp.interfaces;


import com.saida_aliyeva.task_dagger2_mvp.MainActivity;
import com.saida_aliyeva.task_dagger2_mvp.classes.ApiInitModule;
import com.saida_aliyeva.task_dagger2_mvp.classes.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class,ApiInitModule.class})
public interface ApiComponent {

    void inject(MainActivity mainActivity);
}
