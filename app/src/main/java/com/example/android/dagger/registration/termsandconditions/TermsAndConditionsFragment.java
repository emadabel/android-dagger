package com.example.android.dagger.registration.termsandconditions;

import android.content.Context;
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

import javax.inject.Inject;

public class TermsAndConditionsFragment extends Fragment {

    @Inject
    RegistrationViewModel registrationViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        ((RegistrationActivity) getActivity()).registrationComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false);

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
