package com.example.android.dagger.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.dagger.MyApplication;
import com.example.android.dagger.R;
import com.example.android.dagger.login.LoginActivity;
import com.example.android.dagger.user.UserManager;

import javax.inject.Inject;

public class SettingsActivity extends AppCompatActivity {

    @Inject
    SettingsViewModel settingsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        UserManager userManager = ((MyApplication) getApplication()).appComponent.userManager();
        userManager.getUserComponent().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setupViews();
    }

    private void setupViews() {
        Button refreshButton = findViewById(R.id.refresh);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsViewModel.refreshNotifications();
            }
        });

        Button logoutButton = findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsViewModel.logout();
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
