package com.yijia.myapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.yijia.adapter.PicDetailAdapter;
import com.yijia.bean.RecommendDetail;

import java.util.ArrayList;
import java.util.List;

public class PicDetailActivity extends AppCompatActivity {
    List<ImageView> mList;
    LayoutInflater mInflater;
    ViewPager mViewPager;
    ImageView mCollectImageView;
    List<RecommendDetail> mRecommendDetailList;
    boolean flag=false;
   /* private int[] imageIds = new int[]{
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5
    };*/

    PicDetailAdapter mPicDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_detail);
        initview();
        initData();

        mPicDetailAdapter=new PicDetailAdapter(mList);
        mViewPager.setAdapter(mPicDetailAdapter);

    }

    private void initData() {

        mList=new ArrayList<>();
        mRecommendDetailList=new ArrayList<>();
        RecommendDetail Re_detail1=new RecommendDetail(1,1,1, "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic1.jpg");
        RecommendDetail Re_detail2=new RecommendDetail(1,1,1, "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic2.jpg");
        RecommendDetail Re_detail3=new RecommendDetail(1,1,1, "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic3.jpg");
        RecommendDetail Re_detail4=new RecommendDetail(1,1,1, "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic4.jpg");
        RecommendDetail Re_detail5=new RecommendDetail(1,1,1, "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic5.jpg");
        mRecommendDetailList.add(Re_detail1);
        mRecommendDetailList.add(Re_detail2);
        mRecommendDetailList.add(Re_detail3);
        mRecommendDetailList.add(Re_detail4);
        mRecommendDetailList.add(Re_detail5);

        for(int i=0;i<mRecommendDetailList.size();i++){
            ImageView imageView = new ImageView(this);
            Glide.with(PicDetailActivity.this)
                    .load(mRecommendDetailList.get(i).getPic())
                    .into(imageView);
            mList.add(imageView);

        }




       /* mRecommendDetail=new RecommendDetail(1,1,
                "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic1.jpg",
                "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic1.jpg",
                "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic1.jpg",
                "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic1.jpg",
                "http://o7ghiqnts.bkt.clouddn.com/homelistdetailpic1.jpg");*/
       /* for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            mList.add(imageView);
        }*/



    }

    private void initview() {
        mViewPager= (ViewPager) findViewById(R.id.picdetailviewpager);
        mCollectImageView= (ImageView) findViewById(R.id.collect);

    }


    public void backhome(View view) {
        finish();
    }

    public void skipdesignapply(View view) {
        Intent intent=new Intent(PicDetailActivity.this,DesignApplyActivity.class);
        startActivity(intent);
    }

    public void collection(View view) {
        if(flag){
            mCollectImageView.setImageResource(R.mipmap.collect);
            Toast.makeText(PicDetailActivity.this,"取消收藏",Toast.LENGTH_LONG).show();
            flag=false;

        }
        else {
            mCollectImageView.setImageResource(R.mipmap.collectafter);
            Toast.makeText(PicDetailActivity.this,"收藏成功",Toast.LENGTH_LONG).show();
            flag=true;
        }

    }
}
