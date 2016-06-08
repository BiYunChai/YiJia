package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yijia.adapter.MyCollCompAdapter;
import com.yijia.adapter.MyCollRecoAdapter;
import com.yijia.beans.MyCollCompanyData;
import com.yijia.beans.MyCollRecData;
import com.yijia.fragment.CollCompDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class CollTeamActivity extends AppCompatActivity {
    List<MyCollCompanyData> mList;
    MyCollCompAdapter mCollcompAdapter;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_team);
        initData();
        initView();
        mCollcompAdapter=new MyCollCompAdapter(CollTeamActivity.this,mList);
        mListView.setAdapter(mCollcompAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyCollCompanyData myCollCompanyData=mList.get(position);
                Intent intent=new Intent(CollTeamActivity.this, CollCompDetailActivity.class);
                intent.putExtra("CollCompDetail",myCollCompanyData);
                startActivity(intent);
            }
        });
    }
    private void initData() {
        mList=new ArrayList<>();
        MyCollCompanyData r1=new MyCollCompanyData(R.drawable.company1,"公司一公司一公司一公司一公司一","9.7分");
        MyCollCompanyData r2=new MyCollCompanyData(R.drawable.company1,"公司二","9.8分");
        MyCollCompanyData r3=new MyCollCompanyData(R.drawable.company1,"公司三","9.7分");
        MyCollCompanyData r4=new MyCollCompanyData(R.drawable.company1,"公司四","9.7分");
        MyCollCompanyData r5=new MyCollCompanyData(R.drawable.company1,"公司五","9.6分");
        MyCollCompanyData r6=new MyCollCompanyData(R.drawable.company1,"公司六","9.5分");
        mList.add(r1);
        mList.add(r2);
        mList.add(r3);
        mList.add(r4);
        mList.add(r5);
        mList.add(r6);
    }
    private void initView() {
        mListView= (ListView) findViewById(R.id.lv_collcompany);
    }

    public void back(View view) {
        finish();
    }
}
