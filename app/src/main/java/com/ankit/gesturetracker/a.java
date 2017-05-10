package com.ankit.gesturetracker;

import android.view.GestureDetector;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

class a implements OnDoubleTapListener, GestureDetector.OnGestureListener {
  private Activity a;
  private List<Event> b;

  a(Activity var1, List<Event> var2) {
    this.a = var1;
    this.b = var2;
  }

  public boolean onSingleTapConfirmed(MotionEvent var1) {
    Log.d("GesturDetector", "onSingleTapConfirmed: ");
    this.a(var1, "Single Tap");
    return false;
  }

  private void a(MotionEvent var1, String var2) {
    View var3 = this.a(var1);
    long var4 = var1.getEventTime();
    Timestamp var6 = new Timestamp(var4);
    SimpleDateFormat var7 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    String var8 = var7.format(new Date(var6.getTime()));
    Event var9 = new Event(this.a.getClass().getSimpleName(), var2, var3, (double)var1.getX(), (double)var1.getY(), var1.getPressure(), var8, var1.getDownTime());
    this.b.add(var9);
    Toast.makeText(this.a, "Event: " + var2.toUpperCase() + "\nX:" + var1.getX() + " ,Y:" + var1.getY() + " Pressure:" + var1.getPressure(), 0).show();
    Log.d("GesturDetector", "createAndAddEvent: " + this.b);
  }

  public boolean onDoubleTap(MotionEvent var1) {
    Log.d("GesturDetector", "onDoubleTap: ");
    return false;
  }

  public boolean onDoubleTapEvent(MotionEvent var1) {
    Log.d("GesturDetector", "onDoubleTapEvent: ");
    this.a(var1, "Double Tap");
    return false;
  }

  public boolean onDown(MotionEvent var1) {
    Log.d("GesturDetector", "onDown: ");
    return false;
  }

  public void onShowPress(MotionEvent var1) {
    Log.d("GesturDetector", "onShowPress: ");
  }

  public boolean onSingleTapUp(MotionEvent var1) {
    Log.d("GesturDetector", "onSingleTapUp: ");
    return false;
  }

  public boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
    Log.d("GesturDetector", "onScroll: ");
    View var5 = this.a(var1);
    if(var5 instanceof ListView || var5 instanceof ScrollView || var5 instanceof GridView) {
      this.a(var1, "Scrolled");
    }

    return false;
  }

  public void onLongPress(MotionEvent var1) {
    Log.d("GesturDetector", "onLongPress: ");
    this.a(var1, "Long Press");
  }

  public boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
    Log.d("GesturDetector", "onFling: ");
    this.a(var1, "Fling/Swipe");
    return false;
  }

  private View a(MotionEvent var1) {
    Log.d("GesturDetector", "dispatchTouchEvent: " + var1.getAction() + "\t" + var1.getPressure() + "\t" + var1.getDownTime() + "\t" + var1.getSource() + "\t" + var1.getX());
    View var2 = this.a.getWindow().getDecorView().getRootView();
    View var3 = this.a(var2, var1);
    if(var3 != null) {
      Log.d("GesturDetector", "getTouchedView: " + var3.getId());
    }

    return var3;
  }

  private View a(View var1, MotionEvent var2) {
    if(!(var1 instanceof ViewGroup)) {
      int[] var7 = new int[2];
      var1.getLocationOnScreen(var7);
      Rect var8 = new Rect(var7[0], var7[1], var7[0] + var1.getMeasuredWidth(), var7[1] + var1.getMeasuredHeight());
      Log.d("GesturDetector", "view coord: " + var7[0] + "," + var7[1] + "\t" + var2.getX() + "\t" + var2.getY() + "\t" + var8);
      return var8.contains((int)var2.getX(), (int)var2.getY())?var1:null;
    } else {
      ViewGroup var3 = (ViewGroup)var1;

      for(int var4 = 0; var4 < var3.getChildCount(); ++var4) {
        View var5 = var3.getChildAt(var4);
        View var6 = this.a(var5, var2);
        if(var6 != null) {
          return var6;
        }
      }

      return null;
    }
  }
}
