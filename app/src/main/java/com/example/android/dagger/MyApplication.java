package com.example.android.dagger;

import android.app.Application;

import com.example.android.dagger.di.AppComponent;
import com.example.android.dagger.di.DaggerAppComponent;
import com.example.android.dagger.storage.SharedPreferencesStorage;
import com.example.android.dagger.user.UserManager;

public class MyApplication extends Application {

    public AppComponent appComponent;
    public UserManager userManager;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.factory().create(getApplicationContext());
        userManager = new UserManager(new SharedPreferencesStorage(this));
    }
}
