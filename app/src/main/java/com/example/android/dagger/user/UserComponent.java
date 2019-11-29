package com.example.android.dagger.user;

import com.example.android.dagger.main.MainActivity;
import com.example.android.dagger.settings.SettingsActivity;

import dagger.Subcomponent;

@LoggedUserScope
@Subcomponent
public interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        UserComponent create();
    }

    void inject(MainActivity activity);
    void inject(SettingsActivity activity);
}
