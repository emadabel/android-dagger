package com.example.android.dagger.registration.enterdetails;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class EnterDetailsViewModel {
    private static final int MAX_LENGTH = 5;

    private final MutableLiveData<EnterDetailsViewState> _enterDetailsState = new MutableLiveData<>();

    public final LiveData<EnterDetailsViewState> getEnterDetailsState() {
        return this._enterDetailsState;
    }

    public final void validateInput(@NonNull String username, @NonNull String password) {
        if (username.length() < MAX_LENGTH) {
            this._enterDetailsState.setValue(new EnterDetailsFragment.EnterDetailsError("Username has to be longer than 4 characters"));
        } else if (password.length() < MAX_LENGTH) {
            this._enterDetailsState.setValue(new EnterDetailsFragment.EnterDetailsError("Password has to be longer than 4 characters"));
        } else {
            this._enterDetailsState.setValue(new EnterDetailsFragment.EnterDetailsSuccess());
        }
    }
}
