package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.yijia.adapter.CompCertifyAdapter;
import com.yijia.beans.CompanyCertifyData;

import java.util.ArrayList;
import java.util.List;

public class CompanyCertifyActivity extends AppCompatActivity {
List<CompanyCertifyData> mList;
    CompCertifyAdapter mAdapter;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_certify);
       initData();
        mListView= (ListView) findViewById(R.id.com_certifylistview);
        mAdapter=new CompCertifyAdapter(mList,CompanyCertifyActivity.this);
        mListView.setAdapter(mAdapter);
    }

    private void initData() {
        mList=new ArrayList<>();
        CompanyCertifyData certify1=new CompanyCertifyData("http://o7ghiqnts.bkt.clouddn.com/certify.png");
        CompanyCertifyData certify2=new CompanyCertifyData("http://o7ghiqnts.bkt.clouddn.com/certify2.jpg");
        CompanyCertifyData certify3=new CompanyCertifyData("http://o7ghiqnts.bkt.clouddn.com/certify.jpg");
        CompanyCertifyData certify4=new CompanyCertifyData("http://o7ghiqnts.bkt.clouddn.com/certify2.jpg");
        mList.add(certify1);
        mList.add(certify2);
        mList.add(certify3);
        mList.add(certify4);
    }
}
