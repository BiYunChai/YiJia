package com.yijia.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yijia.adapter.MyAdapter;
import com.yijia.fragment.ForumFragment;
import com.yijia.fragment.HomeFragment;
import com.yijia.fragment.LookFragment;
import com.yijia.fragment.MeFragment;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RadioGroup mRadioGroup;//这是大黄的事
    ViewPager mViewPager;


    List<Fragment> mList;

    ForumFragment mForumFragment;
    LookFragment mLookFragment;
    HomeFragment mHomeFragment;
    MeFragment mMeFragment;

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    MyAdapter mMyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();
       initListeners();

    }



    private void initViews() {
        mViewPager= (ViewPager) findViewById(R.id.middle);
        mRadioGroup= (RadioGroup) findViewById(R.id.bottom);
    }

    private void initData() {
        mList=new ArrayList<>();
        mHomeFragment =new HomeFragment();
        mLookFragment=new LookFragment();
        mForumFragment=new ForumFragment();
        mMeFragment=new MeFragment();



        mList.add(mHomeFragment);
        mList.add(mLookFragment);
        mList.add(mForumFragment);
        mList.add(mMeFragment);

        mFragmentManager=getSupportFragmentManager();
        mMyAdapter=new MyAdapter(mFragmentManager,mList);
        mViewPager.setAdapter(mMyAdapter);
    }
    private void initListeners() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetViewPager(checkedId);
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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



    private void resetViewPager(int checkedId) {

        switch (checkedId){
            case R.id.home:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.look:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.forum:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.me:
                mViewPager.setCurrentItem(3);
                break;
        }


    }
    private void resetRadioButton(int position) {

        RadioButton radioButton= (RadioButton) mRadioGroup.getChildAt(position);
        radioButton.setChecked(true);

    }


}
