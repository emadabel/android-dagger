package com.example.android.dagger.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.dagger.user.UserManager;

import javax.inject.Inject;

import static com.example.android.dagger.login.LoginActivity.LoginViewState.LoginError;
import static com.example.android.dagger.login.LoginActivity.LoginViewState.LoginSuccess;

public class LoginViewModel {

    private final MutableLiveData<LoginActivity.LoginViewState> _loginState;
    private final UserManager userManager;

    @Inject
    public LoginViewModel(@NonNull UserManager userManager) {
        this.userManager = userManager;
        this._loginState = new MutableLiveData<>();
    }

    public LiveData<LoginActivity.LoginViewState> getLoginState() {
        return this._loginState;
    }

    public void login(@NonNull String username, @NonNull String password) {
        if (this.userManager.loginUser(username, password)) {
            this._loginState.setValue(LoginSuccess);
        } else {
            this._loginState.setValue(LoginError);
        }
    }

    public void unregister() {
        this.userManager.unregister();
    }

    public String getUsername() {
        return this.userManager.getUsername();
    }
}
