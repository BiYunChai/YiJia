package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CollRecoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coll_reco_detail);
        Toast.makeText(CollRecoDetailActivity.this, "收藏的首页推荐的单个详情信息的界面", Toast.LENGTH_SHORT).show();

    }
}
