package com.yijia.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class PicDetailAdapter extends PagerAdapter {
    List<ImageView> mList;

    public PicDetailAdapter(List<ImageView> mList) {
        this.mList = mList;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view=mList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //销毁position位置处的缓存
        container.removeView(mList.get(position));
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
