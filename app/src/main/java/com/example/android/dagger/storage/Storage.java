package com.example.android.dagger.storage;

public interface Storage {
    void setString(String key, String value);
    String getString(String key);
}
