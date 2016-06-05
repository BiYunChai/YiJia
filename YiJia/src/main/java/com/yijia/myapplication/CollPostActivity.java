package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CollPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_post);
        Toast.makeText(CollPostActivity.this, "收藏的帖子的界面", Toast.LENGTH_SHORT).show();
    }
}
