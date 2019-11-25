package com.example.android.dagger.registration;

import androidx.annotation.NonNull;

import com.example.android.dagger.user.UserManager;

public class RegistrationViewModel {

    private String username;
    private String password;
    private Boolean acceptedTCs;
    private final UserManager userManager;

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

    public RegistrationViewModel(@NonNull UserManager userManager) {
        this.userManager = userManager;
    }
}
