package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MyReplyquesDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_replyques_detail);
        Toast.makeText(MyReplyquesDetailActivity.this, "这是我回复的问题详情页", Toast.LENGTH_SHORT).show();
    }
}
