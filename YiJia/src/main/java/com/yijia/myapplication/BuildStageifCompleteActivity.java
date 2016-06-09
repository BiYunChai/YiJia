package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.yijia.adapter.BuildCompleteRateAdapter;
import com.yijia.beans.BuildStageCompleteRate;

import java.util.ArrayList;
import java.util.List;

public class BuildStageifCompleteActivity extends AppCompatActivity {
    List<BuildStageCompleteRate> mList;
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
        mAdapter=new BuildCompleteRateAdapter(mList,BuildStageifCompleteActivity.this);
        mListView.setAdapter(mAdapter);
    }



    private void initData() {
        mList=new ArrayList<>();
        BuildStageCompleteRate br1=new BuildStageCompleteRate(R.drawable.ques,"水电阶段的介绍信息");
        BuildStageCompleteRate br2=new BuildStageCompleteRate(R.drawable.ques,"水电阶段的介绍信息2");
        BuildStageCompleteRate br3=new BuildStageCompleteRate(R.drawable.ques,"水电阶段的介绍信息3");
        BuildStageCompleteRate br4=new BuildStageCompleteRate(R.drawable.ques,"水电阶段的介绍信息4");
        mList.add(br1);
        mList.add(br2);
        mList.add(br3);
        mList.add(br4);
    }
    private void initViews() {
mListView= (ListView) findViewById(R.id.buildstagecompletelistview);
        mBuildstageratebtn= (Button) findViewById(R.id.buildstageratebtn);
    }

    private void initListener() {
        mBuildstageratebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuildStageifCompleteActivity.this,BuildStageRatingActivity.class);
                startActivity(intent);
            }
        });
    }

}
