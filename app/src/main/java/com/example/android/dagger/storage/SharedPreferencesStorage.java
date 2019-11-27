package com.example.android.dagger.storage;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class SharedPreferencesStorage implements Storage {

    private final SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferencesStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE);
    }

    @Override
    public void setString(String key, String value) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    public String getString(String key) {
        return this.sharedPreferences.getString(key, "");
    }
}
