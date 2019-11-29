package com.example.android.dagger;

import android.app.Application;

import com.example.android.dagger.di.AppComponent;
import com.example.android.dagger.di.DaggerAppComponent;

public class MyApplication extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.factory().create(getApplicationContext());
    }
}
