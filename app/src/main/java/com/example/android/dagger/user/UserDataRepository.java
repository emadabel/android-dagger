package com.example.android.dagger.user;

import java.util.Random;

public class UserDataRepository {

    private final UserManager userManager;
    private int unreadNotifications;

    public UserDataRepository(UserManager userManager) {
        this.userManager = userManager;
        this.unreadNotifications = randomInt();
    }

    public String getUsername() {
        return userManager.getUsername();
    }

    public void refreshUnreadNotifications() {
        this.unreadNotifications = randomInt();
    }

    public int randomInt() {
        return new Random().nextInt(100);
    }
}
