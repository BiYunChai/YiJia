package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yijia.bean.Good;

public class LookGoodsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView mGoodName;
    TextView mGoodPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_goods);

        initview();
        Intent intent=getIntent();
        String str1=intent.getStringExtra("id");
        Log.e("传入的id为",str1);
        int id=Integer.parseInt(str1);
        if(id==1){
            Good good=new Good("欧普照明 古典温馨兰花壁灯 上门安装","166","http://o7ghiqnts.bkt.clouddn.com/dengthree.jpg");
            String name=good.getName();
            String price=good.getPrice();
            String url=good.getPic();
            Glide.with(LookGoodsActivity.this)
                    .load(url)
                    .into(imageView);
            mGoodName.setText(name);
            mGoodPrice.setText(price);

        }
        else if(id==2){
            Good good=new Good("欧普照明 古典温馨花型LED水晶吸顶灯 上门安装","166","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
            String name=good.getName();
            String price=good.getPrice();
            String url=good.getPic();
            Glide.with(LookGoodsActivity.this)
                    .load(url)
                    .into(imageView);
            mGoodName.setText(name);
            mGoodPrice.setText(price);

        }




    }

    private void initview() {
        imageView= (ImageView) findViewById(R.id.look_goodinfo_pic);
        mGoodName= (TextView) findViewById(R.id.gooddescription);
        mGoodPrice= (TextView) findViewById(R.id.good_price);
    }

    public void backlook(View view) {
        finish();
    }

    public void gooddetail(View view) {
        Intent intent=new Intent(LookGoodsActivity.this,GoodsDetaileActivity.class);
        startActivity(intent);
    }

    public void busniessdetail(View view) {
        Intent intent=new Intent(LookGoodsActivity.this,BusniessActivity.class);
        startActivity(intent);
    }
}
