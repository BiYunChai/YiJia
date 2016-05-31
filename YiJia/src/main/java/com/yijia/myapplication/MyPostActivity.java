package com.yijia.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yijia.adapter.MyPostAdapter;
import com.yijia.adapter.MyQuestionAdapter;
import com.yijia.fragment.MyRaisePostFragment;
import com.yijia.fragment.MyRaiseQuesFragment;
import com.yijia.fragment.MyRelyPostFragment;
import com.yijia.fragment.MyReplyQuesFragment;

import java.util.ArrayList;
import java.util.List;

public class MyPostActivity extends AppCompatActivity {
RadioGroup mRadioGrouppost;
    List<Fragment> mListpostFragment;
    MyRaisePostFragment mRaisePostFragment;
    MyRelyPostFragment mRelyPostFragment;
    FragmentManager mFragmentManager;
    ViewPager mViewPagerPost;
    MyPostAdapter mPostAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypost);
        initViews();
        initData();
        initListener();
    }
    private void initViews() {
        mViewPagerPost= (ViewPager) findViewById(R.id.viewpagerpost);
        mRadioGrouppost= (RadioGroup) findViewById(R.id.raiseandrelypost);
    }
    private void initData() {
        mListpostFragment=new ArrayList<>();
       mRaisePostFragment=new MyRaisePostFragment();
        mRelyPostFragment=new MyRelyPostFragment();
        mListpostFragment.add(mRaisePostFragment);
        mListpostFragment.add(mRelyPostFragment);
        mFragmentManager=getSupportFragmentManager();
        mPostAdapter=new MyPostAdapter(mFragmentManager,mListpostFragment);
        mViewPagerPost.setAdapter(mPostAdapter);
    }
    private void initListener() {
        mRadioGrouppost.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetViewpager(checkedId);
            }
        });
        mViewPagerPost.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//根据当前位置默认默认选中单选按钮
                resetRadioButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void resetViewpager(int checkedId) {
        switch (checkedId){
            case R.id.myRaisepost:
                mViewPagerPost.setCurrentItem(0);
                break;
            case R.id.myReplypost:
                mViewPagerPost.setCurrentItem(1);
        }
    }
    private void resetRadioButton(int position) {
        RadioButton radioButton= (RadioButton) mRadioGrouppost.getChildAt(position);
        radioButton.setChecked(true);
    }


}
