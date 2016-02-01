package com.example.msimic.myfirstapp;

import android.app.Application;
import com.localytics.android.*;

import java.util.Random;

/**
 * Created by msimic on 29/05/15.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();

        Localytics.setLoggingEnabled(true);

        /*Register LocalyticsActivityLifecycleCallbacks - automatic*/
        registerActivityLifecycleCallbacks(
                new LocalyticsActivityLifecycleCallbacks(this));

        // Integrate Localytics - manual
        //Localytics.integrate(this);

        // Set custom dimension
        Random randomGenerator = new Random();
        int myRandomNumber = randomGenerator.nextInt(10);

        if ( myRandomNumber % 2 == 0 )
            //Create Custom Dimensions
            Localytics.setCustomDimension(0, "Even");
        else
            Localytics.setCustomDimension(0, "Odd");



    }


}
