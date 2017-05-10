package com.ankit.gesturetracker;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application {
    private EventDetector eventDetector;
    List<Event> eventList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        eventDetector = new EventDetector(this);

        // don't track events on below activity
        eventDetector.excludeActivity("EventActivity");
    }

    public List<Event> getEventList() {
        eventList.addAll(eventDetector.getmEventList());
        return eventList;
    }
}
