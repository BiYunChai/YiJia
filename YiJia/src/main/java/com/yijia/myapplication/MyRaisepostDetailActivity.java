package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MyRaisepostDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_raisepost_detail);
        Toast.makeText(MyRaisepostDetailActivity.this, "这是我提出的帖子详情页", Toast.LENGTH_SHORT).show();
    }
}
