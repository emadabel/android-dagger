package com.example.android.dagger.registration.enterdetails;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.android.dagger.R;
import com.example.android.dagger.registration.RegistrationActivity;
import com.example.android.dagger.registration.RegistrationViewModel;

public class EnterDetailsFragment extends Fragment {

    private RegistrationViewModel registrationViewModel;
    private EnterDetailsViewModel enterDetailsViewModel;

    private TextView errorTextView;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_details, container, false);

        registrationViewModel = ((RegistrationActivity) getActivity()).getRegistrationViewModel();

        enterDetailsViewModel = new EnterDetailsViewModel();
        enterDetailsViewModel.getEnterDetailsState().observe(EnterDetailsFragment.this, new Observer<EnterDetailsViewState>() {
            @Override
            public void onChanged(EnterDetailsViewState state) {
                if (state instanceof EnterDetailsSuccess) {
                    String username = usernameEditText.getText().toString();
                    String password = passwordEditText.getText().toString();
                    registrationViewModel.updateUserData(username, password);

                    ((RegistrationActivity) getActivity()).onDetailsEntered();
                } else if (state instanceof EnterDetailsError) {
                    errorTextView.setText(((EnterDetailsError) state).error);
                    errorTextView.setVisibility(View.VISIBLE);
                }
            }
        });

        setupViews(view);
        return view;
    }

    private void setupViews(View view) {
        errorTextView = view.findViewById(R.id.error);

        usernameEditText = view.findViewById(R.id.username);
        usernameEditText.addTextChangedListener(new TextWatcher() {
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

        passwordEditText = view.findViewById(R.id.password);
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

        Button nextButton = view.findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                enterDetailsViewModel.validateInput(username, password);
            }
        });
    }

    /*enum EnterDetailsViewState {
        EnterDetailsSuccess,
        EnterDetailsError {
            private String error;

            public void setError(String error) {
                this.error = error;
            }

            public String getError() {
                return error;
            }
        };

        private String error;

        EnterDetailsViewState() {}

        public void setError(String error) {
            EnterDetailsError.error = error;
        }
    }*/

    static class EnterDetailsSuccess extends EnterDetailsViewState {
    }

    static class EnterDetailsError extends EnterDetailsViewState {
        private final String error;

//        public final String getError() {
//            return this.error;
//        }

        EnterDetailsError(String error) {
            this.error = error;
        }
    }
}

abstract class EnterDetailsViewState {
    EnterDetailsViewState() {}
}