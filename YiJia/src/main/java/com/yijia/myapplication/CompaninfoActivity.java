package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class CompaninfoActivity extends AppCompatActivity {
TextView mdescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companinfo);
        initView();
        initData();


    }

    private void initView() {
        mdescription= (TextView) findViewById(R.id.description);
    }

    private void initData() {
        Intent intent=getIntent();
        String description=intent.getStringExtra("description");
        Log.e("444444444",description);
      mdescription.setText(description);
    }
}
