package com.yijia.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by laz on 2016/5/28.
 */
public class MyPostAdapter extends FragmentPagerAdapter {
    List<Fragment> mListpostfragment;
    public MyPostAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyPostAdapter(FragmentManager fm, List<Fragment> listpostfragment) {
        super(fm);
        mListpostfragment = listpostfragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mListpostfragment.get(position);
    }

    @Override
    public int getCount() {
        return mListpostfragment.size();
    }
}
