package com.example.android.dagger.di;

import android.content.Context;

import com.example.android.dagger.main.MainActivity;
import com.example.android.dagger.registration.RegistrationActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {StorageModule.class})
public interface AppComponent {

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Context context);
    }

    void inject(RegistrationActivity activity);
    void inject(MainActivity activity);
}
