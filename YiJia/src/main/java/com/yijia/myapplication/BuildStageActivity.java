package com.yijia.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.adapter.MyBuildStageDetailAdagpter;
import com.yijia.bean.ClientStep;
import com.yijia.bean.step;
import com.yijia.bean.step_detail;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class BuildStageActivity extends AppCompatActivity {
     List<step> mList=new ArrayList<>();

    MyBuildStageDetailAdagpter mAdagpter;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_stage);
        Intent intent=getIntent();
        String result=intent.getStringExtra("build");
        Gson gson=new Gson();
        Type type=new TypeToken<List<step>>(){}.getType();
        List<step> stepList=gson.fromJson(result,type);
        Log.e("List<step>",stepList.toString());
        initData(stepList);
        initViews();
        mAdagpter=new MyBuildStageDetailAdagpter(mList,BuildStageActivity.this);
        mListView.setAdapter(mAdagpter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                step step1=mList.get(position);
                List<step_detail> step_details=step1.getStep_details();
                Gson gson=new Gson();
                String result=gson.toJson(step_details);
                Log.e("result",result);
                Intent intent=new Intent(BuildStageActivity.this,BuildStageifComplete2Activity.class);
                intent.putExtra("step_details",result);
                startActivity(intent);
            }
        });
    }

    private void initData(List<step> stepList) {
        for (step step1:stepList) {
            int id=step1.getId();
            int sid=step1.getSid();
            String content=step1.getContent();
            String stepcontent=step1.getStepcontent();
            String stepname=step1.getStepname();
            String company=step1.getCompanyname();
            String score=step1.getScore();
            String statu=step1.getStatu();
            List<step_detail> step_details=step1.getStep_details();
            step step2=new step(id,sid,statu,score,content,company,stepname,step_details,stepcontent);
            mList.add(step2);

        }


    }
    private void initViews() {
    mListView= (ListView) findViewById(R.id.listview_buildstage);
    }

    public void back(View view) {
        finish();
    }
}
