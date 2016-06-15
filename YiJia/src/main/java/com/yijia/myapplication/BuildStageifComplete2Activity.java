package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.adapter.BuildCompleteRateAdapter;
import com.yijia.bean.step_detail;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BuildStageifComplete2Activity extends AppCompatActivity {

    List<step_detail> mList=new ArrayList<>();
    BuildCompleteRateAdapter mAdapter;
    ListView mListView;
    Button mBuildstageratebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_stage_rate);
        initViews();
        initData();
        initListener();
        mAdapter=new BuildCompleteRateAdapter(mList,BuildStageifComplete2Activity.this);
        mListView.setAdapter(mAdapter);
    }



    private void initData() {
        Intent intent=getIntent();
        Gson gson=new Gson();
        Type type=new TypeToken<List<step_detail>>(){}.getType();
        String result=intent.getStringExtra("step_details");
        List<step_detail> step_details=gson.fromJson(result,type);
        for (step_detail step_detail1:step_details) {
            String pic=step_detail1.getStepurl();
            String content=step_detail1.getStepcontent();
            step_detail step_detail2=new step_detail(pic,content);
            mList.add(step_detail2);


        }

    }
    private void initViews() {
        mListView= (ListView) findViewById(R.id.buildstagecompletelistview);
        mBuildstageratebtn= (Button) findViewById(R.id.buildstageratebtn);
    }

    private void initListener() {
        mBuildstageratebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuildStageifComplete2Activity.this,BuildStageRatingActivity.class);
                startActivity(intent);
            }
        });
    }

}
