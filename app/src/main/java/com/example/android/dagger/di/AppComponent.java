package com.example.android.dagger.di;

import android.content.Context;

import com.example.android.dagger.login.LoginComponent;
import com.example.android.dagger.main.MainActivity;
import com.example.android.dagger.registration.RegistrationComponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {StorageModule.class, AppSubcomponents.class})
public interface AppComponent {

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Context context);
    }

    RegistrationComponent.Factory registrationComponent();
    LoginComponent.Factory loginComponent();

    void inject(MainActivity activity);
}
