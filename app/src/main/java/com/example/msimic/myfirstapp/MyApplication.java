package com.example.msimic.myfirstapp;

import android.app.Application;
import com.localytics.android.*;

/**
 * Created by msimic on 29/05/15.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();

        // Integrate Localytics
        //Localytics.integrate(this);

        // Register LocalyticsActivityLifecycleCallbacks
        registerActivityLifecycleCallbacks(
                new LocalyticsActivityLifecycleCallbacks(this));
    }
}
