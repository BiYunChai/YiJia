package com.yijia.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yijia.adapter.MyBuildStageDetailAdagpter;
import com.yijia.beans.MyBuildStageDetail;

import java.util.ArrayList;
import java.util.List;


public class BuildStageActivity extends AppCompatActivity {
List<MyBuildStageDetail> mList;
    MyBuildStageDetailAdagpter mAdagpter;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_stage);
        initData();
        initViews();
        mAdagpter=new MyBuildStageDetailAdagpter(mList,BuildStageActivity.this);
        mListView.setAdapter(mAdagpter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyBuildStageDetail myBuildStageDetail=mList.get(position);
                Intent intent=new Intent(BuildStageActivity.this,BuildStageifCompleteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        mList=new ArrayList<>();
        MyBuildStageDetail s1=new MyBuildStageDetail("准备","恭喜您发布装修需求成功，如有任何疑问请致电宜家客服","2016-02-14",R.mipmap.complete);
        MyBuildStageDetail s2=new MyBuildStageDetail("水电","水电阶段水电阶段水电阶段水电阶段","2016-02-14",R.mipmap.uncomplete);
        MyBuildStageDetail s3=new MyBuildStageDetail("泥木","泥木阶段泥木阶段泥木阶段泥木阶段泥木阶段","2016-02-14",R.mipmap.uncomplete);
        MyBuildStageDetail s4=new MyBuildStageDetail("油漆","油漆阶段油漆阶段油漆阶段油漆阶段油漆阶段","2016-02-14",R.mipmap.uncomplete);
        MyBuildStageDetail s5=new MyBuildStageDetail("竣工","竣工竣工竣工竣工竣工竣工竣工竣工竣工竣工竣工","2016-02-14",R.mipmap.uncomplete);
        MyBuildStageDetail s6=new MyBuildStageDetail("竣工后","竣工后一个月竣工后一个月竣工后一个月竣工后一个月","2016-02-14",R.mipmap.uncomplete);
         mList.add(s1);
        mList.add(s2);
        mList.add(s3);
        mList.add(s4);
        mList.add(s5);
        mList.add(s6);

    }
    private void initViews() {
mListView= (ListView) findViewById(R.id.listview_buildstage);
    }

    public void back(View view) {
        finish();
    }
}
