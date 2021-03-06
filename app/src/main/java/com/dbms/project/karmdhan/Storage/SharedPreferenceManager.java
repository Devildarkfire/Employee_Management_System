package com.dbms.project.karmdhan.Storage;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {
    public static final String SHARED_PREF_NAME = "karmdhanDb";

    public static SharedPreferenceManager mInstance;
    private final Context mCtx;

    private SharedPreferenceManager(Context ctx) {
        mCtx = ctx;
    }

    public static synchronized SharedPreferenceManager getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new SharedPreferenceManager(ctx);
        }
        return mInstance;
    }

    public void saveToken(String token) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("user", token).apply();
    }

    public String getToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("user", null);
    }

    public boolean isAdmin() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("isAdmin", false);
    }

    public void setAdmin(boolean isAdmin) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("isAdmin", isAdmin).apply();
    }

    public void clear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
