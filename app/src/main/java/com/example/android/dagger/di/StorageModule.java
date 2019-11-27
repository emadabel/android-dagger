package com.example.android.dagger.di;

import com.example.android.dagger.storage.SharedPreferencesStorage;
import com.example.android.dagger.storage.Storage;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class StorageModule {

    @Binds
    abstract Storage provideStorage(SharedPreferencesStorage storage);
}
