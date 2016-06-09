package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BuildStageRateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_stage_rate);
        Toast.makeText(BuildStageRateActivity.this, "这是阶段评分界面", Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
        finish();
    }
}
