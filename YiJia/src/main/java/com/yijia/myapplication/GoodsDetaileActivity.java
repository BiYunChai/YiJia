package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.yijia.adapter.GoodsDetailAdapter;
import com.yijia.adapter.KnowledgeAdapter;
import com.yijia.bean.GoodsDetail;
import com.yijia.bean.Knowledge;

import java.util.ArrayList;
import java.util.List;

public class GoodsDetaileActivity extends AppCompatActivity {
    ImageView mBackImg;
    ListView mListView;
    GoodsDetailAdapter mGoodsDetailAdapter;
    List<GoodsDetail> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detaile);
        initview();
        initData();
    }

    private void initview() {
        mBackImg= (ImageView) findViewById(R.id.back);
        mListView= (ListView) findViewById(R.id.goodsdetail);
    }

    private void initData() {
        mlist=new ArrayList<>();
        GoodsDetail gt1=new GoodsDetail("http://o7ghiqnts.bkt.clouddn.com/goodsdetileone.jpg");
        GoodsDetail gt2=new GoodsDetail("http://o7ghiqnts.bkt.clouddn.com/goodsdetiletwo.jpg");
        GoodsDetail gt3=new GoodsDetail("http://o7ghiqnts.bkt.clouddn.com/goodsdetilethree.jpg");
        GoodsDetail gt4=new GoodsDetail("http://o7ghiqnts.bkt.clouddn.com/goodsdetilefour.jpg");
        GoodsDetail gt5=new GoodsDetail("http://o7ghiqnts.bkt.clouddn.com/goodsdetilefive.jpg");
        GoodsDetail gt6=new GoodsDetail("http://o7ghiqnts.bkt.clouddn.com/goodsdetilesix.jpg");

        mlist.add(gt1);
        mlist.add(gt2);
        mlist.add(gt3);
        mlist.add(gt4);
        mlist.add(gt5);
        mlist.add(gt6);

        mGoodsDetailAdapter=new GoodsDetailAdapter(GoodsDetaileActivity.this,mlist);
        mListView.setAdapter(mGoodsDetailAdapter);
    }

    public void backlook(View view) {
        finish();
    }
}
