package com.yijia.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class CompanyAdapter extends FragmentPagerAdapter {
    List<Fragment> mList;

    public CompanyAdapter(FragmentManager fm, List<Fragment> mList) {
        super(fm);
        this.mList = mList;
    }
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
