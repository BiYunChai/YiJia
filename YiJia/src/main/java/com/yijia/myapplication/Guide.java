package com.yijia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yijia.adapter.GuideViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/21 0021.
 */
public class Guide extends Activity implements ViewPager.OnPageChangeListener {
    private ViewPager guidevp;
    private GuideViewPagerAdapter vpAdapter;
    private List<View> views;
    private ImageView[] dots;
    private int[] ids = {R.id.iv1,R.id.iv2,R.id.iv3};
    private Button start_btn;
    private  ImageView guideimgone;
    private  ImageView guideimgtwo;
    private  ImageView guideimgthree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        initViews();
        initDots();
    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<>();
        View view1=inflater.inflate(R.layout.one,null);
        View view2=inflater.inflate(R.layout.two,null);
        View view3=inflater.inflate(R.layout.three,null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        guideimgone= (ImageView)view1.findViewById(R.id.guide_one);
        guideimgtwo= (ImageView) view2.findViewById(R.id.guide_two);
        guideimgthree= (ImageView) view3.findViewById(R.id.guide_three);
        Glide.with(Guide.this)
                .load("http://o7ghiqnts.bkt.clouddn.com/guide_one.jpg")
                .into(guideimgtwo);
        Glide.with(Guide.this)
                .load("http://o7ghiqnts.bkt.clouddn.com/guide_two.jpg")
                .into(guideimgone);
        Glide.with(Guide.this)
                .load("http://o7ghiqnts.bkt.clouddn.com/guide_three.jpg")
                .into(guideimgthree);

        vpAdapter = new GuideViewPagerAdapter(views,this);
        guidevp = (ViewPager) findViewById(R.id.viewpager);
        guidevp.setAdapter(vpAdapter);
        start_btn = (Button) views.get(2).findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guide.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        guidevp.setOnPageChangeListener(this);
    }
    private void initDots(){
        dots = new ImageView[views.size()];
        for (int i = 0;i<views.size();i++){
            dots[i] = (ImageView) findViewById(ids[i]);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i=0;i<ids.length;i++){
            if(position == i){
               /* Glide.with(Guide.this)
                        .load("http://o7ghiqnts.bkt.clouddn.com/login_point_selected.png")
                        .into(dots[i]);*/
                dots[i].setImageResource(R.mipmap.dot_focused);
            }else {
                /*Glide.with(Guide.this)
                        .load("http://o7ghiqnts.bkt.clouddn.com/login_point.png")
                        .into(dots[i]);*/
               dots[i].setImageResource(R.mipmap.dot_normal);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
