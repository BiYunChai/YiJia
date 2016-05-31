package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MyReplypostDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_replypost_detail);
        Toast.makeText(MyReplypostDetailActivity.this, "这是我回复的帖子详情页", Toast.LENGTH_SHORT).show();
    }
}
