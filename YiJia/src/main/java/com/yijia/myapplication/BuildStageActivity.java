package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yijia.beans.MyBuild;

public class BuildStageActivity extends AppCompatActivity {
    TextView textViewstage;
    TextView textViewstage2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_stage);
        initView();
        Intent intent=getIntent();
        //获取意图中携带的数据
        MyBuild myBuild= (MyBuild) intent.getSerializableExtra("build");
        String text=myBuild.getMybuild();
        String date=myBuild.getDate();
        textViewstage.setText(text);
        textViewstage2.setText(date);
    }

    private void initView() {
        textViewstage= (TextView) findViewById(R.id.stage);
        textViewstage2= (TextView) findViewById(R.id.stage2);
    }
}
