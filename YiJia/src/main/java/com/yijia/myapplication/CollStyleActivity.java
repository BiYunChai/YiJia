package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CollStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_style);
        Toast.makeText(CollStyleActivity.this, "收藏的装修风格的界面", Toast.LENGTH_SHORT).show();
    }
}
