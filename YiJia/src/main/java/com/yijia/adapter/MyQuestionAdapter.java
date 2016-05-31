package com.yijia.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by laz on 2016/5/27.
 */
public class MyQuestionAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragmentList;

    public MyQuestionAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyQuestionAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList=fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}

