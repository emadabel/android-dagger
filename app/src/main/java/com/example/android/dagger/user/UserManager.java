package com.example.android.dagger.user;

import com.example.android.dagger.storage.Storage;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserManager {

    private final static String REGISTERED_USER = "registered_user";
    private final static String PASSWORD_SUFFIX = "password";

    private final Storage storage;
    private UserDataRepository userDataRepository = null;


    @Inject
    public UserManager(Storage storage) {
        this.storage = storage;
    }

    public String getUsername() {
        return storage.getString(REGISTERED_USER);
    }

    public boolean isUserLoggedIn() {
        return userDataRepository != null;
    }

    public boolean isUserRegistered() {
        return !storage.getString(REGISTERED_USER).isEmpty();
    }

    public UserDataRepository getUserDataRepository() {
        return userDataRepository;
    }

    public void registerUser(String username, String password) {
        storage.setString(REGISTERED_USER, username);
        storage.setString(username + PASSWORD_SUFFIX, password);
        userJustLoggedIn();
    }

    public boolean loginUser(String username, String password) {
        String registeredUser = this.getUsername();
        if (!registeredUser.equals(username)) return false;

        String registeredPassword = storage.getString(username + PASSWORD_SUFFIX);
        if (!registeredPassword.equals(password)) return false;

        userJustLoggedIn();
        return true;
    }

    public void logout() {
        userDataRepository = null;
    }

    public void unregister() {
        String username = storage.getString(REGISTERED_USER);
        storage.setString(REGISTERED_USER, "");
        storage.setString(username + PASSWORD_SUFFIX, "");
        logout();
    }

    private void userJustLoggedIn() {
        userDataRepository = new UserDataRepository(this);
    }
}
