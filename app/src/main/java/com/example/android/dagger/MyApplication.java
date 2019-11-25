package com.example.android.dagger;

import android.app.Application;

import com.example.android.dagger.storage.SharedPreferencesStorage;
import com.example.android.dagger.user.UserManager;

public class MyApplication extends Application {

    public final UserManager userManager = new UserManager(new  SharedPreferencesStorage(this));;
}
