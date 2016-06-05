package com.yijia.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yijia.adapter.GoodsDetailAdapter;
import com.yijia.adapter.LookListAdapter;
import com.yijia.bean.Busniess;
import com.yijia.bean.Good;

import java.util.ArrayList;
import java.util.List;

public class BusniessActivity extends AppCompatActivity {
    PullToRefreshListView mListView;
    List<Good> goodlist;
    TextView mNameText;
    TextView mSaleText;
    TextView mPromiseText;
    TextView mTelText;
    TextView mAddressText;
    ImageView mImageView;
    LookListAdapter Bus_goodsListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busniess);
        LayoutInflater inflater=LayoutInflater.from(BusniessActivity.this);
        View viewheader= inflater.inflate(R.layout.busniessheader,null);

        //初始化listview控件
        initView();
        //添加头部
        initheaderView(viewheader);
        //初始化头部中的数据
        initHeadeData();
        //初始化数据
        initListData();
        //监听listview
        initListener();
    }




    private void initView() {
        mListView= (PullToRefreshListView) findViewById(R.id.busniesslistview);
    }

    private void initheaderView(View view) {
        //pulltorefresh没有addHeaderView方法 ，但内部有listview
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        ListView lv=mListView.getRefreshableView();

        lv.addHeaderView(view);


    }


    private void initHeadeData() {
        Busniess busniess=new Busniess(1,"http://o7ghiqnts.bkt.clouddn.com/2685227_145314011_2.jpg","格瑞灯饰","水晶吊灯、欧式客厅灯、现代简约卧室灯罩、北欧餐厅灯具","上门安装，三月包换，一年保修","05211234567","苏州市平江区景德路190-192号");
        mImageView= (ImageView)findViewById(R.id.busniesslogo);

        mNameText= (TextView) findViewById(R.id.busniessname);
        mSaleText= (TextView) findViewById(R.id.sale);
        mPromiseText= (TextView) findViewById(R.id.busniesspromise);
        mTelText= (TextView) findViewById(R.id.busniesstel);
        mAddressText= (TextView) findViewById(R.id.busniessaddress);


        String logoURL=busniess.getLogo();
        Glide.with(BusniessActivity.this)
                .load(logoURL)
                .into(mImageView);


        mNameText.setText(busniess.getName());
        mSaleText.setText(busniess.getSale());
        mPromiseText.setText(busniess.getPromise());
        mTelText.setText(busniess.getTel());
        mAddressText.setText(busniess.getAddress());
    }
    private void initListData() {
        goodlist=new ArrayList<>();
        Good g1=new Good("现代简约LED客厅卧室花式吸顶灯","138","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
        Good g2=new Good("现代简约LED客厅卧室花式吸顶灯","138","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
        Good g3=new Good("现代简约LED客厅卧室花式吸顶灯","138","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
        Good g4=new Good("现代简约LED客厅卧室花式吸顶灯","138","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
        Good g5=new Good("现代简约LED客厅卧室花式吸顶灯","138","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
        Good g6=new Good("现代简约LED客厅卧室花式吸顶灯","138","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");

        goodlist.add(g1);
        goodlist.add(g2);
        goodlist.add(g3);
        goodlist.add(g4);
        goodlist.add(g5);
        goodlist.add(g6);

        Bus_goodsListAdapter=new LookListAdapter(BusniessActivity.this,goodlist);
        mListView.setAdapter(Bus_goodsListAdapter);




    }

    private void initListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(BusniessActivity.this,LookGoodsActivity.class);
                intent.putExtra("id","2");

                startActivity(intent);
            }
        });
    }

    public void backlook(View view) {
        finish();
    }
}
