package com.example.android.dagger.settings;

import com.example.android.dagger.user.UserDataRepository;
import com.example.android.dagger.user.UserManager;

import javax.inject.Inject;

public class SettingsViewModel {

    private final UserDataRepository userDataRepository;
    private final UserManager userManager;

    @Inject
    public SettingsViewModel(UserDataRepository userDataRepository, UserManager userManager) {
        this.userDataRepository = userDataRepository;
        this.userManager = userManager;
    }

    public void refreshNotifications() {
        userDataRepository.refreshUnreadNotifications();
    }

    public void logout() {
        userManager.logout();
    }
}
