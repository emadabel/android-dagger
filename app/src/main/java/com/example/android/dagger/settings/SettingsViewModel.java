package com.example.android.dagger.settings;

import com.example.android.dagger.user.UserDataRepository;
import com.example.android.dagger.user.UserManager;

public class SettingsViewModel {

    private final UserDataRepository userDataRepository;
    private final UserManager userManager;

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
