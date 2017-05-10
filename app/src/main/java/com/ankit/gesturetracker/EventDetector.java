package com.ankit.gesturetracker;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.Log;
import android.view.Window.Callback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventDetector implements ActivityLifecycleCallbacks {
  private Application a;
  private List<Event> b = new ArrayList();
  private List<String> c = new ArrayList();

  private EventDetector() {
  }

  public EventDetector(Application var1) {
    this.a = var1;
    var1.registerActivityLifecycleCallbacks(this);
  }

  public void onActivityCreated(Activity var1, Bundle var2) {
    Iterator var3 = this.c.iterator();

    String var4;
    do {
      if(!var3.hasNext()) {
        Log.d("EventDetector", "onActivityCreated: Name " + var1.getClass().getSimpleName());
        Callback var5 = var1.getWindow().getCallback();
        var1.getWindow().setCallback(new b(var5, var1, this.b));
        return;
      }

      var4 = (String)var3.next();
    } while(!var4.equals(var1.getClass().getSimpleName()));

  }

  public void onActivityStarted(Activity var1) {
  }

  public void onActivityResumed(Activity var1) {
  }

  public void onActivityPaused(Activity var1) {
  }

  public void onActivityStopped(Activity var1) {
  }

  public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
  }

  public void onActivityDestroyed(Activity var1) {
  }

  public List<Event> getmEventList() {
    return this.b;
  }

  public void excludeActivity(String var1) {
    this.c.add(var1);
  }
}
