package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CollMaterialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_material);
        Toast.makeText(CollMaterialActivity.this, "收藏的建材的界面", Toast.LENGTH_SHORT).show();
    }
}
