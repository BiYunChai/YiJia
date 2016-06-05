package com.yijia.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yijia.adapter.MyAdapterbuild;
import com.yijia.beans.MyBuild;

import java.util.ArrayList;
import java.util.List;

public class MyBuildActivity extends AppCompatActivity {
    List<MyBuild> mList;
    MyAdapterbuild mAdapterbuild;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build);
        initData();
        mListView= (ListView) findViewById(R.id.listview_build);
        mAdapterbuild=new MyAdapterbuild(mList,MyBuildActivity.this);
        mListView.setAdapter(mAdapterbuild);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //parent代表整个listView,view表示当前行的视图，position表示用户单击了哪一行
                MyBuild myBuild=mList.get(position);
                Intent intent=new Intent(MyBuildActivity.this,BuildStageActivity.class);
                intent.putExtra("build",myBuild);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        mList=new ArrayList<>();
        MyBuild b1=new MyBuild("我的新家1","2016-01-01");
        MyBuild b2=new MyBuild("我的新家2","2016-01-20");
        MyBuild b3=new MyBuild("我的新家3","2016-02-01");
        MyBuild b4=new MyBuild("我的新家4","2016-03-01");
        MyBuild b5=new MyBuild("我的新家5","2016-04-01");
        MyBuild b6=new MyBuild("我的新家6","2016-05-01");
        mList.add(b1);
        mList.add(b2);
        mList.add(b3);
        mList.add(b4);
        mList.add(b5);
        mList.add(b6);
    }

    public void backME(View view) {
        finish();
    }
}
