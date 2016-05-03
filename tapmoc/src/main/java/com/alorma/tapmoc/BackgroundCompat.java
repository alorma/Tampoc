package com.alorma.tapmoc;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class BackgroundCompat {

  static final BackgroundCompatImpl IMPL;

  static {
    final int version = Build.VERSION.SDK_INT;
    if (version >= Build.VERSION_CODES.JELLY_BEAN) {
      IMPL = new JellyBeanBackgroundCompatImpl();
    } else {
      IMPL = new BaseBackgroundCompatImpl();
    }
  }

  public static void setBackground(View view, Drawable drawable) {
    IMPL.setBackground(view, drawable);
  }

  interface BackgroundCompatImpl {
    void setBackground(View view, Drawable drawable);
  }

  static class BaseBackgroundCompatImpl implements BackgroundCompatImpl {

    @Override
    public void setBackground(View view, Drawable drawable) {
      view.setBackgroundDrawable(drawable);
    }
  }

  static class JellyBeanBackgroundCompatImpl implements BackgroundCompatImpl {

    @Override
    public void setBackground(View view, Drawable drawable) {
      view.setBackground(drawable);
    }
  }
}
