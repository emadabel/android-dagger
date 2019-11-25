package com.example.android.dagger;

import android.app.Application;

import com.example.android.dagger.storage.SharedPreferencesStorage;
import com.example.android.dagger.user.UserManager;

public class MyApplication extends Application {

    public UserManager userManager;

    @Override
    public void onCreate() {
        super.onCreate();
        userManager = new UserManager(new SharedPreferencesStorage(this));
    }
}
