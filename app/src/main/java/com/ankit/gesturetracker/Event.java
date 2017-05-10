package com.ankit.gesturetracker;

import android.view.View;

public class Event {
  public String activityName;
  public String action;
  public View targetView;
  public double x;
  public double y;
  public float pressure;
  public String time;
  public long downTime;

  public Event(String var1, String var2, View var3, double var4, double var6, float var8, String var9, long var10) {
    this.activityName = var1;
    this.action = var2;
    this.targetView = var3;
    this.x = var4;
    this.y = var6;
    this.pressure = var8;
    this.time = var9;
    this.downTime = var10;
  }

  public String toString() {
    return "Event{activityName=\'" + this.activityName + '\'' + ", action=\'" + this.action + '\'' + ", targetView=" + this.targetView + ", x=" + this.x + ", y=" + this.y + ", pressure=" + this.pressure + ", time=" + this.time + ", downTime=" + this.downTime + '}';
  }
}
