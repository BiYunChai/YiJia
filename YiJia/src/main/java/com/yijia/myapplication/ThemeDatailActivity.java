package com.yijia.myapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.adapter.PicDetailAdapter;
import com.yijia.bean.RecommendDetail;
import com.yijia.bean.ThemePicDetail;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ThemeDatailActivity extends AppCompatActivity {
    List<ImageView> mList=new ArrayList<>();
    LayoutInflater mInflater;
    ViewPager mViewPager;
    ImageView mCollectImageView;

    boolean flag=false;


    PicDetailAdapter mPicDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_datail);

        Intent intent=getIntent();
        String details=intent.getStringExtra("themedetail");
        Gson gson=new Gson();
        Type type= new TypeToken<List<ThemePicDetail>>(){}.getType();
        List<ThemePicDetail> mlist=gson.fromJson(details,type);
        Log.e("yun",mlist.toString());

        initview();
        initData(mlist);
    }

    private void initData(List<ThemePicDetail> themeDetails) {


        Log.e("yun","进入initdata");
        for(int i=0;i<themeDetails.size();i++){
            ImageView imageView = new ImageView(this);
            Glide.with(ThemeDatailActivity.this)
                    .load(themeDetails.get(i).getAddress())
                    .into(imageView);
            mList.add(imageView);

        }
        mPicDetailAdapter=new PicDetailAdapter(mList);
        mViewPager.setAdapter(mPicDetailAdapter);






    }

    private void initview() {
        mViewPager= (ViewPager) findViewById(R.id.picdetailviewpager);
        mCollectImageView= (ImageView) findViewById(R.id.collect);

    }


    public void backhome(View view) {
        finish();
    }

    public void skipdesignapply(View view) {
        Intent intent=new Intent(ThemeDatailActivity.this,DesignApplyActivity.class);
        startActivity(intent);
    }

    public void collection(View view) {
        if(flag){
            mCollectImageView.setImageResource(R.mipmap.collect);
            Toast.makeText(ThemeDatailActivity.this,"取消收藏",Toast.LENGTH_LONG).show();
            flag=false;

        }
        else {
            mCollectImageView.setImageResource(R.mipmap.collectafter);
            Toast.makeText(ThemeDatailActivity.this,"收藏成功",Toast.LENGTH_LONG).show();
            flag=true;
        }

    }
}
