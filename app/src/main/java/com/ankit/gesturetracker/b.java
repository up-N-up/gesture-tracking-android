package com.ankit.gesturetracker;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import java.util.List;

class b implements Window.Callback {
  private Window.Callback a;
  private Activity b;
  private GestureDetectorCompat c;

  b(Window.Callback var1, Activity var2, List<Event> var3) {
    this.a = var1;
    this.b = var2;
    a var4 = new a(var2, var3);
    this.c = new GestureDetectorCompat(var2, var4);
    this.c.setOnDoubleTapListener(var4);
  }

  public boolean dispatchGenericMotionEvent(MotionEvent var1) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
      return this.a.dispatchGenericMotionEvent(var1);
    }
    return false;
  }

  public boolean dispatchKeyEvent(KeyEvent var1) {
    return this.a.dispatchKeyEvent(var1);
  }

  public boolean dispatchKeyShortcutEvent(KeyEvent var1) {
    return this.a.dispatchKeyShortcutEvent(var1);
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
    return this.a.dispatchPopulateAccessibilityEvent(var1);
  }

  public boolean dispatchTouchEvent(MotionEvent var1) {
    this.c.onTouchEvent(var1);
    return this.a.dispatchTouchEvent(var1);
  }

  public boolean dispatchTrackballEvent(MotionEvent var1) {
    return this.a.dispatchTrackballEvent(var1);
  }

  public void onActionModeFinished(ActionMode var1) {
    this.a.onActionModeFinished(var1);
  }

  public void onActionModeStarted(ActionMode var1) {
    this.a.onActionModeStarted(var1);
  }

  public void onAttachedToWindow() {
    this.a.onAttachedToWindow();
  }

  public void onContentChanged() {
    this.a.onContentChanged();
  }

  public boolean onCreatePanelMenu(int var1, Menu var2) {
    return this.a.onCreatePanelMenu(var1, var2);
  }

  public View onCreatePanelView(int var1) {
    return this.a.onCreatePanelView(var1);
  }

  @SuppressLint({"MissingSuperCall"})
  public void onDetachedFromWindow() {
    this.a.onDetachedFromWindow();
  }

  public boolean onMenuItemSelected(int var1, MenuItem var2) {
    return this.a.onMenuItemSelected(var1, var2);
  }

  public boolean onMenuOpened(int var1, Menu var2) {
    return this.a.onMenuOpened(var1, var2);
  }

  public void onPanelClosed(int var1, Menu var2) {
    this.a.onPanelClosed(var1, var2);
  }

  public boolean onPreparePanel(int var1, View var2, Menu var3) {
    return this.a.onPreparePanel(var1, var2, var3);
  }

  public boolean onSearchRequested() {
    return this.a.onSearchRequested();
  }

  public boolean onSearchRequested(SearchEvent var1) {
    return false;
  }

  public void onWindowAttributesChanged(WindowManager.LayoutParams var1) {
    this.a.onWindowAttributesChanged(var1);
  }

  public void onWindowFocusChanged(boolean var1) {
    this.a.onWindowFocusChanged(var1);
  }

  public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1) {
    return this.a.onWindowStartingActionMode(var1);
  }

  @Nullable
  public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1, int var2) {
    return null;
  }
}
