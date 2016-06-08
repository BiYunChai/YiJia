package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.yijia.adapter.DesigninspirateAdapter;
import com.yijia.beans.DesignData;

import java.util.ArrayList;
import java.util.List;

public class CompanyDesignActivity extends AppCompatActivity {
    List<DesignData> mList;
    DesigninspirateAdapter mAdapter;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_design);
         initData();
        mListView= (ListView) findViewById(R.id.design_program);
       mAdapter=new DesigninspirateAdapter(CompanyDesignActivity.this,mList);
        mListView.setAdapter(mAdapter);
    }

    private void initData() {
        mList=new ArrayList<>();
        DesignData d1=new DesignData("楼盘名称：小石城","设计者：默默","风格：新古典","面积：100平方米","预报价：8~10万","房型：小户型","楼盘地址：苏州吴中","设计灵感：***",R.drawable.coll_recommend);
        DesignData d2=new DesignData("楼盘名称：小石城","设计者：默默","风格：新古典","面积：100平方米","预报价：8~10万","房型：小户型","楼盘地址：苏州吴中","设计灵感：***",R.drawable.coll_recommend);
        DesignData d3=new DesignData("楼盘名称：小石城","设计者：默默","风格：新古典","面积：100平方米","预报价：8~10万","房型：小户型","楼盘地址：苏州吴中","设计灵感：***",R.drawable.coll_recommend);
        DesignData d4=new DesignData("楼盘名称：小石城","设计者：默默","风格：新古典","面积：100平方米","预报价：8~10万","房型：小户型","楼盘地址：苏州吴中","设计灵感：***",R.drawable.coll_recommend);
        mList.add(d1);
        mList.add(d2);
        mList.add(d3);
        mList.add(d4);
    }
}
