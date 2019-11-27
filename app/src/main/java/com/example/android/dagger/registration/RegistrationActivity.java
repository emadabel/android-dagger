package com.example.android.dagger.registration;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.dagger.MyApplication;
import com.example.android.dagger.R;
import com.example.android.dagger.main.MainActivity;
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment;
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment;

import javax.inject.Inject;

public class RegistrationActivity extends AppCompatActivity {

    @Inject
    RegistrationViewModel registrationViewModel;

    public RegistrationViewModel getRegistrationViewModel() {
        return registrationViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((MyApplication) getApplication()).appComponent.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_holder, new EnterDetailsFragment())
                .commit();
    }

    public void onDetailsEntered() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_holder, new TermsAndConditionsFragment())
                .addToBackStack(TermsAndConditionsFragment.class.getSimpleName())
            .commit();
    }

    public void onTermsAndConditionsAccepted() {
        registrationViewModel.registerUser();
        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
