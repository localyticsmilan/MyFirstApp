package com.example.msimic.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.localytics.android.Localytics;


public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_message);

        //Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        //Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        //Set the text view as the activity layout
        setContentView(textView);

        //call the Localytics tag method
        this.milanEvent();

        Localytics.triggerInAppMessage("myTriggerName");
    }

    //Localytics event string
    private static String TAG_MILAN_EVENT = "Milan's Special Event 30 Sept";
    private static String OPTIONS_SAVED = "Options Saved";
    private static Random randomGenerator = new Random();
    private int optionsSaved;

    //Localytics event tag method
    public void milanEvent() {

        //optionsSaved = randomGenerator.nextInt(100);

        Map<String,String> values = new HashMap<String,String>();
        //values.put(OPTIONS_SAVED, String.valueOf(this.optionsSaved));
        values.put("menu test 3", "true");
        //Localytics.tagEvent(this.TAG_MILAN_EVENT, values);
        Localytics.tagEvent("Display Message", values);

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_message, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Localytics.openSession();
        Localytics.tagScreen("Display Message");
        Localytics.triggerInAppMessage("Display Message");
        Localytics.upload();
    }

    @Override
    protected void onPause() {
        Localytics.closeSession();
        Localytics.upload();

        super.onPause();
    }

}
