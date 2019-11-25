package com.example.android.dagger.registration.termsandconditions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.dagger.R;
import com.example.android.dagger.registration.RegistrationActivity;
import com.example.android.dagger.registration.RegistrationViewModel;

public class TermsAndConditionsFragment extends Fragment {
    private RegistrationViewModel registrationViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false);

        registrationViewModel = ((RegistrationActivity) getActivity()).getRegistrationViewModel();

        Button nextButton = view.findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationViewModel.acceptTCs();
                ((RegistrationActivity) getActivity()).onTermsAndConditionsAccepted();
            }
        });

        return view;
    }
}
