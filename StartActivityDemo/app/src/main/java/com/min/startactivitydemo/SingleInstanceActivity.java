package com.min.startactivitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SingleInstanceActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SingleInstanceActivity";

    private Button mStandardBtn;
    private Button mSingleTopBtn;
    private Button mSingleTaskBtn;
    private Button mSingleInstanceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard);

        mStandardBtn = findViewById(R.id.standard);
        mSingleTopBtn = findViewById(R.id.singleTop);
        mSingleTaskBtn = findViewById(R.id.singleTask);
        mSingleInstanceBtn = findViewById(R.id.singleInstance);

        mStandardBtn.setOnClickListener(this);
        mSingleTopBtn.setOnClickListener(this);
        mSingleTaskBtn.setOnClickListener(this);
        mSingleInstanceBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (mStandardBtn == v) {
            startActivity(new Intent(this, StandardActivity.class));
        } else if (mSingleTopBtn == v) {
            startActivity(new Intent(this, SingleTopActivity.class));
        } else if (mSingleTaskBtn == v) {
            startActivity(new Intent(this, SingleTaskActivity.class));
        } else if (mSingleInstanceBtn == v) {
            startActivity(new Intent(this, SingleInstanceActivity.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getClass().getSimpleName(), "onDestroy");
    }
}
