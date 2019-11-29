package com.example.android.dagger.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.dagger.MyApplication;
import com.example.android.dagger.R;
import com.example.android.dagger.login.LoginActivity;
import com.example.android.dagger.registration.RegistrationActivity;
import com.example.android.dagger.settings.SettingsActivity;
import com.example.android.dagger.user.UserManager;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserManager userManager = ((MyApplication) getApplication()).appComponent.userManager();
        if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
                finish();
            } else {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        } else {
            setContentView(R.layout.activity_main);

            userManager.getUserComponent().inject(this);
            setupViews();
        }
    }

    private void setupViews() {
        TextView helloText = findViewById(R.id.hello);
        Button logoutButton = findViewById(R.id.logout);

        helloText.setText(mainViewModel.getWelcomeText());
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView notificationsText = findViewById(R.id.notifications);
        notificationsText.setText(mainViewModel.getNotificationsText());
    }
}
