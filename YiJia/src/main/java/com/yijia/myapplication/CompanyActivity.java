package com.yijia.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yijia.adapter.CompanyAdapter;

import com.yijia.fragment.CompanyLocationCity;
import com.yijia.fragment.CompanyScoreFragnment;

import com.yijia.utils.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class CompanyActivity extends AppCompatActivity {
    RadioGroup mRadioGroup;
    MyViewPager mViewPager;


    List<Fragment> mList;

    CompanyLocationCity mCompanyLocationFrag;
    CompanyScoreFragnment mCompanyScoreFragnment;

    FragmentManager mFragmentManager;
    //FragmentTransaction mFragmentTransaction;

    CompanyAdapter mCompanyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company);

        initViews();
        initData();
        initListeners();

    }



    private void initViews() {
        mViewPager= (MyViewPager) findViewById(R.id.companymiddle);
        mRadioGroup= (RadioGroup) findViewById(R.id.companytop);
    }

    private void initData() {
        mList=new ArrayList<>();
        mCompanyLocationFrag=new CompanyLocationCity();
        mCompanyScoreFragnment=new CompanyScoreFragnment();


        mList.add(mCompanyLocationFrag);
        mList.add(mCompanyScoreFragnment);


        mFragmentManager=getSupportFragmentManager();
        mCompanyAdapter=new CompanyAdapter(mFragmentManager,mList);
        mViewPager.setAdapter(mCompanyAdapter);
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
            case R.id.samecity:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.score:
                mViewPager.setCurrentItem(1);
                break;

        }


    }
    private void resetRadioButton(int position) {

        RadioButton radioButton= (RadioButton) mRadioGroup.getChildAt(position);
        radioButton.setChecked(true);

    }


    public void backhome(View view) {
        /*Intent intent=new Intent(DesignApplyActivity.this, HomeFragment.class);
        startActivity(intent);*/
        finish();
    }
}
