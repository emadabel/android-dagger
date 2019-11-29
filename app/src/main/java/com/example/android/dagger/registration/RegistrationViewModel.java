package com.example.android.dagger.registration;

import androidx.annotation.NonNull;

import com.example.android.dagger.di.ActivityScope;
import com.example.android.dagger.user.UserManager;

import javax.inject.Inject;

@ActivityScope
public class RegistrationViewModel {

    private final UserManager userManager;
    private String username;
    private String password;
    private Boolean acceptedTCs;

    @Inject
    public RegistrationViewModel(@NonNull UserManager userManager) {
        this.userManager = userManager;
    }

    public void updateUserData(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }

    public void acceptTCs() {
        this.acceptedTCs = true;
    }

    public void registerUser() {
        if (username == null || password == null || !acceptedTCs) return;

        userManager.registerUser(username, password);
    }
}
