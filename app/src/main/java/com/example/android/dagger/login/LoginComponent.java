package com.example.android.dagger.login;

import com.example.android.dagger.di.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        LoginComponent create();
    }

    void inject(LoginActivity activity);
}
