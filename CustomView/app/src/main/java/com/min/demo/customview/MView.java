package com.min.demo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MView extends View {

    private static final String TAG = MView.class.getSimpleName();


    public MView(Context context) {
        this(context, null);
    }

    public MView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.StyleInTheme);
    }

    public MView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, R.style.StyleForDefStyleRes);
    }

    public MView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MView, defStyleAttr, defStyleRes);
        Log.e(TAG, "mview_1: " + a.getString(R.styleable.MView_mview_1));
        Log.e(TAG, "mview_2: " + a.getString(R.styleable.MView_mview_2));
        Log.e(TAG, "mview_3: " + a.getString(R.styleable.MView_mview_3));
        Log.e(TAG, "mview_4: " + a.getString(R.styleable.MView_mview_4));
        Log.e(TAG, "mview_5: " + a.getString(R.styleable.MView_mview_5));
        a.recycle();
    }
}
