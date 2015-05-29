package com.onliquid.simple;


import android.app.Application;

import io.lqd.sdk.Liquid;

public class SimpleApp extends Application {

    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Liquid.initialize(this, "DEVELOPMENT_API_TOKEN", BuildConfig.DEBUG);
        } else {
            Liquid.initialize(this, "PRODUCTION_API_TOKEN", BuildConfig.DEBUG);
        }
    }
}
