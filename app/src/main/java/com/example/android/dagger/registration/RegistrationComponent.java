package com.example.android.dagger.registration;

import com.example.android.dagger.di.ActivityScope;
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment;
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        RegistrationComponent create();
    }

    void inject(RegistrationActivity activity);
    void inject(EnterDetailsFragment fragment);
    void inject(TermsAndConditionsFragment fragment);
}
