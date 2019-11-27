package com.example.android.dagger.main;

import com.example.android.dagger.user.UserDataRepository;

import javax.inject.Inject;

public final class MainViewModel {
    private final UserDataRepository userDataRepository;

    @Inject
    public MainViewModel(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public final String getWelcomeText() {
        return "Hello " + this.userDataRepository.getUsername() + "!";
    }

    public final String getNotificationsText() {
        return "You have " + this.userDataRepository.getUnreadNotifications() + " unread notifications";
    }
}
