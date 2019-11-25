package com.example.android.dagger.main;

import com.example.android.dagger.user.UserDataRepository;

public final class MainViewModel {
    private final UserDataRepository userDataRepository;

    public final String getWelcomeText() {
        return "Hello " + this.userDataRepository.getUsername() + "!";
    }

    public final String getNotificationsText() {
        return "You have " + this.userDataRepository.getUnreadNotifications() + " unread notifications";
    }

    public MainViewModel(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }
}
