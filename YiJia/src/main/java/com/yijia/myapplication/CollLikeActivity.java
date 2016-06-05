package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yijia.adapter.MyCollRecoAdapter;
import com.yijia.beans.MyCollRecData;

import java.util.ArrayList;
import java.util.List;

public class CollLikeActivity extends AppCompatActivity {
List<MyCollRecData> mList;
    MyCollRecoAdapter mCollRecoAdapter;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_like);
        initData();
        initViews();
        mCollRecoAdapter=new MyCollRecoAdapter(mList,CollLikeActivity.this);
        mListView.setAdapter(mCollRecoAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyCollRecData myCollRecData=mList.get(position);
                Intent intent=new Intent(CollLikeActivity.this,CollRecoDetailActivity.class);
                intent.putExtra("CollRecoDetail",myCollRecData);
                startActivity(intent);
            }
        });
    }
    private void initData() {
        mList=new ArrayList<>();
        MyCollRecData r1=new MyCollRecData(R.drawable.coll_recommend,"主题一主题一主题一主题一主题一","2016-06-01");
        MyCollRecData r2=new MyCollRecData(R.drawable.coll_recommend,"主题二","2016-06-01");
        MyCollRecData r3=new MyCollRecData(R.drawable.coll_recommend,"主题三","2016-06-01");
        MyCollRecData r4=new MyCollRecData(R.drawable.coll_recommend,"主题四","2016-06-01");
        MyCollRecData r5=new MyCollRecData(R.drawable.coll_recommend,"主题五","2016-06-01");
        MyCollRecData r6=new MyCollRecData(R.drawable.coll_recommend,"主题六","2016-06-01");
        mList.add(r1);
        mList.add(r2);
        mList.add(r3);
        mList.add(r4);
        mList.add(r5);
        mList.add(r6);
    }
    private void initViews() {
        mListView= (ListView) findViewById(R.id.lv_collreco);
    }

    public void back(View view) {
        finish();
    }
}
