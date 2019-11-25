package com.example.android.dagger.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.android.dagger.MyApplication;
import com.example.android.dagger.R;
import com.example.android.dagger.main.MainActivity;
import com.example.android.dagger.registration.RegistrationActivity;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private TextView errorTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new LoginViewModel(((MyApplication) getApplication()).userManager);
        loginViewModel.getLoginState().observe(LoginActivity.this, new Observer<LoginViewState>() {
            @Override
            public void onChanged(LoginViewState state) {
                if (state == LoginViewState.LoginSuccess) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else if (state == LoginViewState.LoginError) {
                    errorTextView.setVisibility(View.VISIBLE);
                }
            }
        });

        errorTextView = findViewById(R.id.error);
        setupViews();
    }

    private void setupViews() {
        final EditText usernameEditText = findViewById(R.id.username);
        usernameEditText.setEnabled(false);
        usernameEditText.setText(loginViewModel.getUsername());

        final EditText passwordEditText = findViewById(R.id.password);
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                errorTextView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });

        Button unregisterButton = findViewById(R.id.unregister);
        unregisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.unregister();
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    enum LoginViewState {
        LoginSuccess,
        LoginError
    }
}

